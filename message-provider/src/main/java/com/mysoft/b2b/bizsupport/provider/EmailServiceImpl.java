/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.provider;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysoft.b2b.bizsupport.api.IdGenerationService;
import com.mysoft.b2b.bizsupport.api.email.EmailJob;
import com.mysoft.b2b.bizsupport.api.email.EmailJobCriteria;
import com.mysoft.b2b.bizsupport.api.email.EmailLog;
import com.mysoft.b2b.bizsupport.api.email.EmailLogCriteria;
import com.mysoft.b2b.bizsupport.api.email.EmailService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.mapper.EmailMapper;

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

@Service(value="emailService")
public class EmailServiceImpl implements EmailService {
    
    private Logger logger = Logger.getLogger(EmailService.class);
    
    @Autowired
    private EmailMapper emailMapper;
    
    @Autowired
    private IdGenerationService idGenerationService;

    @Override
    @Transactional
    public EmailJob insertEmailJob(EmailJob job) {
        if(job == null){
            logger.error("新建邮件任务失败，任务为空...");
            return null;
        }
        if(StringUtils.isEmpty(job.getEmailJobId())){
            logger.info("邮件任务ID为空，后台服务自动生成任务ID...");
            String pk = idGenerationService.getNextId("b2b_support.bizp_email_job")+"";
            job.setEmailJobId(pk);
        }
        emailMapper.insertEmailJob(job);
        return job;
    }

    @Override
    @Transactional
    public EmailJob updateEmailJob(EmailJob job) {
        if(job == null){
            logger.error("更新邮件任务失败，任务为空...");
            return null;
        }
        emailMapper.updateEmailJob(job);
        return job;
    }

    @Override
    @Transactional
    public void deleteEmailJob(EmailJob job) {
        if(job !=null && StringUtils.isNotEmpty(job.getEmailJobId())){
            emailMapper.deleteEmailJob(job.getEmailJobId());
        }
    }

    @Override
    @Transactional
    public void deleteEmailJob(String jobId) {
        if(StringUtils.isNotEmpty(jobId)){
            emailMapper.deleteEmailJob(jobId);
        }

    }

    @Override
    public EmailJob getEmailJob(String jobId) {
        if(StringUtils.isEmpty(jobId))
            return null;
        return emailMapper.getEmailJob(jobId);
    }

    @Override
    public EmailJobCriteria getEmailJobList(EmailJobCriteria criteria) {
        if(criteria == null)
            return null;
        criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
        List<EmailJob> data = emailMapper.getEmailJobList(criteria);
        int total = emailMapper.getEmailJobListCount(criteria);
        criteria.setList(data);
        criteria.setTotalRows(total);
        return criteria;
    }

    @Override
    @Transactional
    public EmailLog insertEmailLog(EmailLog job) {
        if(job == null){
            logger.error("新建邮件任务失败，任务为空...");
            return null;
        }
        if (StringUtils.isEmpty(job.getEmailLogId())){
            String pk = idGenerationService.getNextId("b2b_support.bizp_mail_log")+"";
            logger.info("插入邮件日志时, 邮件日志ID为空，后台服务自动生成任务ID...， id=" + pk);
            job.setEmailLogId(pk);
        } else {
        	 logger.info("插入邮件日志时, 邮件日志ID不为空， id=" + job.getEmailLogId());
        }
        int addCount = emailMapper.insertEmailLog(job);
		if (addCount > 0) {
			logger.info("插入发送邮件成功log成功, id=" + job.getEmailLogId());
		} else {
			logger.info("插入发送邮件成功log失败, id=" + job.getEmailLogId());
		}
        return job;
    }

    @Override
    @Transactional
    public EmailLog updateEmailLog(EmailLog job) {
        if(job == null){
            logger.error("更新邮件任务失败，任务为空...");
            return null;
        }
        emailMapper.updateEmailLog(job);
        return job;
    }

    @Override
    @Transactional
    public void deleteEmailLog(EmailLog job) {
         if(job != null && StringUtils.isNotEmpty(job.getEmailLogId())){
            emailMapper.deleteEmailLog(job.getEmailLogId());
         }
    }

    @Override
    @Transactional
    public void deleteEmailLog(String logId) {
         if(StringUtils.isNotEmpty(logId)){
            emailMapper.deleteEmailLog(logId);
          }
    }

    @Override
    public EmailLog getEmailLog(String logId) {
        if(StringUtils.isEmpty(logId))
            return null;
        return emailMapper.getEmailLog(logId);
    }

    @Override
    public EmailLogCriteria getEmailLogList(EmailLogCriteria criteria) {
        if(criteria == null)
            return null;
        criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
        List<EmailLog> data = emailMapper.getEmailLogList(criteria);
        int total = emailMapper.getEmailLogListCount(criteria);
        criteria.setList(data);
        criteria.setTotalRows(total);
        return criteria;
    }
    
    @Override
    public int getEmailLogListCount(EmailLogCriteria criteria) {
    	if(criteria == null)
            return 0;
    	return emailMapper.getEmailLogListCount(criteria);
    }

    @Override
    @Transactional
    public void dealEmailJob(boolean flag, EmailJob job) {
        if(flag){
            insertEmailLog(job.getEmailLog());
            deleteEmailJob(job);
        }else{
            this.updateEmailJob(job);
        }
    }

    @Override
    public List<EmailJob> getSchedulerEmailJobList(EmailJobCriteria criteria) {
        logger.info("...getSchedulerEmailJobList start criteria====>" + criteria);
        return emailMapper.getSchedulerEmailJobList(criteria);
    }

}
