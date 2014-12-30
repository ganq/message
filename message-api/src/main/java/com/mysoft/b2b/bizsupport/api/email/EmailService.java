/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.email;

import java.util.List;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月13日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public interface EmailService {
    
    /**
     * 新建邮件任务
     * @param job
     * @return
     */
    public EmailJob insertEmailJob(EmailJob job);
    
    /**
     * 更新邮件任务
     * @param job
     * @return
     */
    public EmailJob updateEmailJob(EmailJob job);
    
    /**
     * 删除邮件任务
     * @param job
     */
    public void deleteEmailJob(EmailJob job);
    
    /**
     * 删除邮件任务
     * @param jobId
     */
    public void deleteEmailJob(String jobId);
    
    /**
     * 查询邮件任务
     * @param job
     * @return
     */
    public EmailJob getEmailJob(String jobId);
    
    /**
     * 分页查询邮件任务
     * @param criteria
     * @return
     */
    public EmailJobCriteria getEmailJobList(EmailJobCriteria criteria);
    
    /**
     * 新建邮件日志
     * @param job
     * @return
     */
    public EmailLog insertEmailLog(EmailLog job);
    
    /**
     * 更新邮件日志
     * @param job
     * @return
     */
    public EmailLog updateEmailLog(EmailLog job);
    
    /**
     * 删除邮件日志
     * @param job
     */
    public void deleteEmailLog(EmailLog job);
    
    /**
     * 删除邮件日志
     * @param logId
     */
    public void deleteEmailLog(String logId);
    
    /**
     * 查询邮件日志
     * @param jobId
     * @return
     */
    public EmailLog getEmailLog(String jobId);
    
    /**
     * 分页查询邮件日志
     * @param criteria
     * @return
     */
    public EmailLogCriteria getEmailLogList(EmailLogCriteria criteria);
    
    /**
     * 查询邮件日志总记录数
     * @param criteria
     * @return
     */
    int getEmailLogListCount(EmailLogCriteria criteria);
    
    /**
     * 处理邮件任务
     * @param flag
     * @param job
     */
    public void dealEmailJob(boolean flag, EmailJob job);
    
    /**
     * 获取调度任务数据
     * @param criteria
     * @return
     */
    public List<EmailJob> getSchedulerEmailJobList(EmailJobCriteria criteria);
    
}
