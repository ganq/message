/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysoft.b2b.bizsupport.api.IdGenerationService;
import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.api.sms.SMSJobCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSLog;
import com.mysoft.b2b.bizsupport.api.sms.SMSLogCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSReply;
import com.mysoft.b2b.bizsupport.api.sms.SMSService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.mapper.SMSMapper;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月14日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
@Service("smsService")
public class SMSServiceImpl implements SMSService {

    private static final Logger logger = Logger.getLogger(SMSServiceImpl.class);

    @Autowired
    private SMSMapper smsMapper;

    @Autowired
    private IdGenerationService idGenerationService;
    
    @Override
    public String generateSMSJobId(){
        return idGenerationService.getNextId("b2b_support.bizp_sms_job") + "";
    }
    
    @Override
    @Transactional
    public SMSJob insertSMSJob(SMSJob job) {
        logger.debug("...insertSMSJob start ====>" + job);

        if (null != job) {
            if (StringUtils.isEmpty(job.getSmsJobId())) {
                job.setSmsJobId(generateSMSJobId());
                smsMapper.insertSMSJob(job);
                return job;
            } else {
                return updateSMSJob(job);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public SMSJob updateSMSJob(SMSJob job) {

        logger.debug("...updateSMSJob start ====>" + job);

        smsMapper.updateSMSJob(job);
        return job;
    }

    @Override
    @Transactional
    public void deleteSMSJob(SMSJob job) {
        logger.debug("...deleteSMSJob start ====>" + job);

        if (job != null && StringUtils.isNotEmpty(job.getSmsJobId())) {
            smsMapper.deleteSMSJob(job.getSmsJobId());
        }
    }

    @Override
    @Transactional
    public void deleteSMSJob(String jobId) {
        logger.debug("...deleteSMSJob start jobId====>" + jobId);

        if (StringUtils.isNotEmpty(jobId)) {
            smsMapper.deleteSMSJob(jobId);
        }
    }

    @Override
    public SMSJob getSMSJob(String jobId) {
        logger.debug("...getSMSJob start ====>" + jobId);
        if (StringUtils.isEmpty(jobId))
            return null;
        return smsMapper.getSMSJob(jobId);
    }

    @Override
    public SMSJobCriteria getSMSJobList(SMSJobCriteria criteria) {
        logger.debug("...getSMSJobList start criteria====>" + criteria);

        if (criteria == null)
            return null;
        criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
        List<SMSJob> data = smsMapper.getSMSJobList(criteria);
        int total = smsMapper.getSMSJobTotal(criteria);
        criteria.setList(data);
        criteria.setTotalRows(total);
        return criteria;
    }

    @Override
    @Transactional
    public SMSLog insertSMSLog(SMSLog log) {

        logger.debug("...insertSMSLog start log====>" + log);

        if (null != log) {
            //这里直接拿的是jobid作为logid
            smsMapper.insertSMSLog(log);
            return log;
        }
        return null;
    }

    @Override
    @Transactional
    public SMSLog updateSMSLog(SMSLog log) {

        logger.debug("...updateSMSLog start log====>" + log);

        if (null != log) {
            smsMapper.updateSMSLog(log);
            return log;
        }
        return null;

    }

    @Override
    @Transactional
    public void deleteSMSLog(SMSLog log) {
        logger.debug("...deleteSMSLog start log====>" + log);

        if (StringUtils.isNotEmpty(log.getSmsLogId())) {
            smsMapper.deleteSMSLog(log.getSmsLogId());
        }
    }

    @Override
    @Transactional
    public void deleteSMSLog(String logId) {
        logger.debug("...deleteSMSLog start logId====>" + logId);
        if (StringUtils.isNotEmpty(logId)) {
            smsMapper.deleteSMSLog(logId);
        }
    }

    @Override
    public SMSLog getSMSLog(String logId) {
        logger.debug("...getSMSLog start log====>" + logId);
        if (StringUtils.isNotEmpty(logId))
            return smsMapper.getSMSLog(logId);
        return null;
    }

    @Override
    public SMSLogCriteria getSMSLogList(SMSLogCriteria criteria) {
        logger.debug("...getSMSLogList start criteria====>" + criteria);
        if (criteria == null)
            return null;
        criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
        List<SMSLog> data = smsMapper.getSMSLogList(criteria);
        int total = smsMapper.getSMSLogTotal(criteria);
        criteria.setList(data);
        criteria.setTotalRows(total);
        return criteria;
    }
    
    @Override
    public int getSMSLogTotal(SMSLogCriteria criteria) {
    	logger.debug("...getSMSLogList start criteria====>" + criteria);
        if (criteria == null)
            return 0;
    	return smsMapper.getSMSLogTotal(criteria);
    }

    @Override
    @Transactional
    public void dealSMSJob(boolean flag, SMSJob job) {
        logger.debug("...dealSMSJob start job====>" + job);
        if (flag) {
            insertSMSLog(job.getSMSLog());
            deleteSMSJob(job);
        } else {
            this.updateSMSJob(job);
        }
    }

    @Override
    public List<SMSJob> getSchedulerSMSJobList(SMSJobCriteria criteria) {
        logger.info("...getSchedulerSMSJobList start criteria====>" + criteria);
        return smsMapper.getSchedulerSMSJobList(criteria);
    }
    
    @Override
    @Transactional
    public boolean dealSMSReply(List<SMSReply> replyList) {
    	boolean isSucc = false;
		if (replyList != null && !replyList.isEmpty()) {
			int sum = 0;
			int dealSum = 0;
			int size = replyList.size();
			for (SMSReply smsReply : replyList) {
				String content = smsReply.getContent();
				String mobile = smsReply.getMobile();
				logger.info( "退订的手机号码: "+ mobile +  "; 退订内容: " + content);
				if("TD".equalsIgnoreCase(StringUtils.trim(content))) {
					boolean isUnsub = false;
					if (StringUtils.isNotBlank(mobile)) {
						isUnsub = smsMapper.isUnsubscribled(mobile) > 0;
					}
					if (isUnsub) {
						Log.info("mobile: " + mobile + " 之前已经退订");
					} else {
						long genId = idGenerationService.getNextId("b2b_operation.op_rejected_message");
						smsReply.setId(genId + "");
						smsReply.setCreatedTime(new Date());
						if (StringUtils.isNotBlank(mobile)) {
							// 优先取名片记录表, 不存在从供应商基本表查找
							Map<String, Object> suppInfo = smsMapper.getSupplierInfo(mobile);
							if (suppInfo == null || suppInfo.isEmpty()) {
								suppInfo = smsMapper.getSupplierInfo2(mobile);
							}
							if (suppInfo != null && !suppInfo.isEmpty()) {
								String userId = (String)suppInfo.get("userId");
								String companyId = (String)suppInfo.get("companyId");
								smsReply.setUserId(userId);
								smsReply.setCompanyId(companyId);
							} 
						}
						int rtnCount = smsMapper.dealSMSReply(smsReply);
						dealSum += rtnCount;
						sum ++;
					}
				}
			}
			logger.info("dealSum: " + dealSum + "; sum: " + sum + "; size: " + size);
			isSucc = true;
			if (sum != dealSum) {
				logger.warn("需要处理的和实际处理的短信数量不一致，请检查是否有误");
			}
    	}
    	return isSucc;
    }

}
