/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.email.EmailJob;
import com.mysoft.b2b.bizsupport.api.email.EmailJobCriteria;
import com.mysoft.b2b.bizsupport.api.email.EmailLog;
import com.mysoft.b2b.bizsupport.api.email.EmailLogCriteria;

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

public interface EmailMapper {
    /**
     * 新建邮件任务
     * @param job
     * @return
     */
    public void insertEmailJob(EmailJob job);
    
    /**
     * 更新邮件任务
     * @param job
     * @return
     */
    public void updateEmailJob(EmailJob job);
    
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
    public List<EmailJob> getEmailJobList(EmailJobCriteria criteria);
    
    /**
     * 分页查询邮件任务总数
     * @param criteria
     * @return
     */
    public int getEmailJobListCount(EmailJobCriteria criteria);
    
    /**
     * 新建邮件日志
     * @param job
     * @return
     */
    public int insertEmailLog(EmailLog job);
    
    /**
     * 更新邮件日志
     * @param job
     * @return
     */
    public void updateEmailLog(EmailLog job);
    
    
    /**
     * 删除邮件日志
     * @param logId
     */
    public void deleteEmailLog(String logId);
    
    /**
     * 查询邮件日志
     * @param job
     * @return
     */
    public EmailLog getEmailLog(String logId);
    
    /**
     * 分页查询邮件日志
     * @param criteria
     * @return
     */
    public List<EmailLog> getEmailLogList(EmailLogCriteria criteria);
    
    /**
     * 分页查询邮件日志总数
     * @param criteria
     * @return
     */
    public int getEmailLogListCount(EmailLogCriteria criteria);

    /**
     * 获取调度任务邮件任务集合
     * @param criteria
     * @return
     */
    public List<EmailJob> getSchedulerEmailJobList(EmailJobCriteria criteria);
}
