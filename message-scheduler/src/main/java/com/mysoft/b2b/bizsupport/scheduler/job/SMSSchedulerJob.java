/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.job;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

import com.mysoft.b2b.bizsupport.api.MessageChannel;
import com.mysoft.b2b.bizsupport.api.MessageContants;
import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.api.sms.SMSJobCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.scheduler.sms.SMSConfig;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.ChannelService;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.SMSMessageBean;
import com.mysoft.b2b.bizsupport.scheduler.util.MysoftJob;
import com.mysoft.b2b.bizsupport.scheduler.util.SpringContextAware;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public class SMSSchedulerJob extends MysoftJob {
	
	@Override
    public void run() {
		Set<String> sms2MessageTypeSet = new HashSet<String>();
		// 短信通道2的模板的类型列表
		String sms2MessageTypeCodes = "";
		if (this.context != null) {
			JobDetail jdtl = this.context.getJobDetail();
			if (jdtl != null) {
				JobDataMap jobDataMap = jdtl.getJobDataMap();
				if (jobDataMap != null) {
					sms2MessageTypeCodes = (String) jobDataMap.get("sms2MessageTypeCodes");
					logger.info("sms2MessageTypeCodes: " + sms2MessageTypeCodes);
				}
			}
		} else {
			logger.info("JobExecutionContext is null ");
		}
		if (StringUtils.isNotBlank(sms2MessageTypeCodes)) {
			String[] arr = StringUtils.split(sms2MessageTypeCodes, ",");
			for (String item : arr) {
				sms2MessageTypeSet.add(StringUtils.trim(item));
			}
		}
    	SMSConfig smsConfig = null;
        SMSConfig config = (SMSConfig)SpringContextAware.getBean("smsConfig");
        ChannelService channelService = config.getChannelService();
        SMSConfig config2 = (SMSConfig)SpringContextAware.getBean("smsConfig2");
        SMSService smsService = SpringContextAware.getBean(SMSService.class);
        
        SMSJobCriteria criteria = new SMSJobCriteria();
        criteria.setCurrentPage(1);
        criteria.setPageSize(5);
        criteria.setTryTimes(3);
        criteria.setLastSentTime(MessageUtil.getDateBefore(3));
        List<SMSJob> jobs = smsService.getSchedulerSMSJobList(criteria);
        
        if(jobs!=null&&jobs.size() > 0){
            for (SMSJob job : jobs) {
                try {
                    this.startToDealJob(job, smsService);
                    // 当为商机推送模板时，取对应的配置
                    smsConfig = sms2MessageTypeSet.contains(job.getMessageTypeCode()) ? config2 : config;
                    channelService.sendSMS(new SMSMessageBean(job, smsConfig, 
                            getReceiverList(job.getReceiver(), MessageChannel.SMS.getValue())));
                } catch (Exception e) {
                    this.finishToDealJob(false, job, smsService, e);
                }
            }
        }
    }

    private void startToDealJob(SMSJob job, SMSService smsService){
        if(job != null){
            job.setStatus(MessageContants.SMS_STATUS_DEALING);
            job.setLastSentTime(new Date());
            smsService.updateSMSJob(job);
        }
    }
    
    private void finishToDealJob(boolean flag, SMSJob job, SMSService smsService, Exception e){
        if(job != null){
            if(flag){
//                job.setStatus(MessageContants.SMS_STATUS_SUCCESS);
//                job.setTryTimes(job.getTryTimes()+1);
//                smsService.dealSMSJob(flag, job);
            }else{
                if(e != null){
                    job.setRemark(e.getMessage());
                }
                job.setTryTimes(job.getTryTimes()+1);
                job.setStatus(MessageContants.SMS_STATUS_FAILED);
                smsService.dealSMSJob(flag, job);
            }
        }
    }
    
}
