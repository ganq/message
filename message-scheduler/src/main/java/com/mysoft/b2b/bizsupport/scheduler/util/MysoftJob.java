package com.mysoft.b2b.bizsupport.scheduler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mysoft.b2b.bizsupport.api.MessageReceiver;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.commons.exception.PlatformUncheckException;

/**
 * 
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
public abstract class MysoftJob implements Job {

	//
	protected Logger logger = Logger.getLogger(this.getClass());

    protected String jobName;
	protected String cronExpression;
	protected Map<String, Object> params;
	//
	protected Lock lock = null;
	protected JobExecutionContext context;

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		this.context = context;
		this.lock = (Lock)context.getJobDetail().getJobDataMap().get(SchedulerManager.LOCK_OBJECT_KEY);
		if (lock.tryLock()) {
			try {
				logger.warn("=======开始执行调度任务=====" + context.getJobDetail().getName());
				// Start job task
				run();
				// End job task
				logger.warn("=======执行调度任务结束=====" + context.getJobDetail().getName());
			} catch (PlatformUncheckException ex) {
				logger.error("Failed to excute job in scheduler, " + ex.toString(), ex);
			}  catch (Exception ex) {
                logger.error("Failed to excute job in scheduler, " + ex.toString(), ex);
            } finally {
				lock.unlock();
			}
		} else {
			logger.warn("================定时调度任务正在运行，请不需要重复尝试================" + context.getJobDetail().getName());
		}
	}

	public abstract void run();

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getCronExpression(){
        return cronExpression;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * 获取发送地址
     * @param receiver
     * @param messageChannel
     * @return
     */
    protected List<String> getReceiverList(String receiver, Integer messageChannel) {
        List<MessageReceiver> receivers = MessageUtil.getObjectArrayByJSON(receiver, MessageReceiver.class);
        if (receiver != null && receivers.size() > 0) {
            List<String> list = new ArrayList<String>();
            for (MessageReceiver messageReceiver : receivers) {
                if (null != messageReceiver) {
                    String addr = messageReceiver.getAddrMap().get(messageChannel);
                    if (StringUtils.isNotEmpty(addr)) {
                        list.add(addr);
                    }
                }
            }
            return list;
        } else {
            throw new PlatformUncheckException("接受者为空", null);
        }
    }
    
    
}
