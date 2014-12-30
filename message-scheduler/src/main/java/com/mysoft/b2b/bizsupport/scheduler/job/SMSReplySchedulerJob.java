/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.job;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

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

public class SMSReplySchedulerJob extends MysoftJob {

	private static final Logger logger = Logger.getLogger(SMSReplySchedulerJob.class);
	
    @Override
    public void run() {
        SMSConfig config = (SMSConfig)SpringContextAware.getBean("smsConfig");
        ChannelService channelService = config.getChannelService();
        try {
			channelService.dealReply(new SMSMessageBean(null, config));
		} catch (Exception e) {
			logger.error("运行短信接受调度任务出错...", e);
		}
    }

    
}
