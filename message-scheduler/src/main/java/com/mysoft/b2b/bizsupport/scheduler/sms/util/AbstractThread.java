/**
 * Copyright ecVision Limited (c) 2013. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of ecVision Limited.  Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from ecVision or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.sms.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.mysoft.b2b.bizsupport.api.MessageContants;
import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.api.sms.SMSReply;
import com.mysoft.b2b.bizsupport.api.sms.SMSService;
import com.mysoft.b2b.bizsupport.scheduler.util.SpringContextAware;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp     1.0           2014年8月15日     Created
 *
 * </pre>
 * @since 8.
 */
public abstract class AbstractThread implements Runnable {

    protected Logger logger = Logger.getLogger(this.getClass());
    /**
     * 发送失败后，短信重发次数
     */
    public static final int TRY_TIMES_INTHREAD = 3;
    
    protected SMSMessageBean bean;

    protected SMSOperationEnum operation;

    /**
     * 
     * @param bean
     * @param operation
     */
    public AbstractThread(SMSMessageBean bean, SMSOperationEnum operation) {
        this.bean = bean;
        this.operation = operation;
    }

    /**
     * 
     */
    @Override
    public void run() {
        switch (operation) {
        case SMS_SEND:
            try {
                send();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            break;
        case SMS_REPLY:
            try {
                getReply();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            break;
        case SMS_RECEIPT:
            try {
                dealReceipt();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            break;
        case SMS_ACCOUNT:
            try {
                dealReceipt();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            break;
        }
    }

    /**
     * 发送短信,发送失败会重试一下.
     * @throws Exception
     */
    protected void send() throws Exception {
        int count = 0;
        while (count < TRY_TIMES_INTHREAD) {
            boolean flag = this.sendMessage(bean);
            if (flag) {
                this.sendSuccess(bean);
                count = TRY_TIMES_INTHREAD;
            } else {
                if (count == TRY_TIMES_INTHREAD - 1) {
                    this.sendFail(bean);
                }
                //这里的重发次数不记录,一次线程任务统计为一次,在定时任务中重新开启线程任务时才算另外一次
                count += 1;
            }
        }
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    protected abstract boolean sendMessage(SMSMessageBean bean) throws Exception;
    
    /**
     * 
     * @return
     * @throws Exception
     */
    protected abstract ReplyResultBean getReplys(SMSMessageBean bean) throws Exception;
    
    /**
     * 接受上行短信
     * 
     * @param bean
     * @return
     * @throws Exception
     */
    protected abstract List<SMSReply> receiveReplys(SMSMessageBean bean) throws Exception;
    
    /**
     * 
     * @throws Exception
     */
    protected abstract void confirmReply() throws Exception;

    /**
     * 
     * @return
     * @throws Exception
     */
    protected abstract List<SendResultReceipt> getReceipt(SMSMessageBean bean) throws Exception;

    /**
     * 处理短信回执结果
     */
    protected void dealReceipt() throws Exception {
        //已经拿到的回执数据重新创建发送任务
        
    }

    /**
     * 
     * @throws Exception
     */
    protected void getReply() throws Exception {
    	List<SMSReply> replyList =  this.receiveReplys(bean);
		if (replyList != null && !replyList.isEmpty()) {
			SpringContextAware.getBean(SMSService.class).dealSMSReply(replyList);
		}
    }
    
    /**
     * 发送成功
     * @param bean
     * @throws Exception
     */
    protected void sendSuccess(SMSMessageBean bean) throws Exception {
        SMSJob job = bean.getJob();
        job.setStatus(MessageContants.SMS_STATUS_SUCCESS);
        job.setTryTimes(job.getTryTimes() + 1);
        SpringContextAware.getBean(SMSService.class).dealSMSJob(true, job);
    }

    /**
     * 发送失败
     * @param bean
     * @throws Exception
     */
    protected void sendFail(SMSMessageBean bean) throws Exception {
        SMSJob job = bean.getJob();
        job.setStatus(MessageContants.SMS_STATUS_FAILED);
        job.setTryTimes(job.getTryTimes() + 1);
        SpringContextAware.getBean(SMSService.class).dealSMSJob(true, job);
    }

}
