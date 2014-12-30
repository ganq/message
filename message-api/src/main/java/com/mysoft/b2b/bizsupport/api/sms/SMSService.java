/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sms;

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

public interface SMSService {

    /**
     * 生成记录ID
     * @return
     */
    public String generateSMSJobId();
    
    /**
     * 新建短信任务
     * @param job
     * @return
     */
    public SMSJob insertSMSJob(SMSJob job);

    /**
     * 更新短信任务
     * @param job
     * @return
     */
    public SMSJob updateSMSJob(SMSJob job);

    /**
     * 删除短信任务
     * @param job
     */
    public void deleteSMSJob(SMSJob job);

    /**
     * 删除短信任务
     * @param jobId
     */
    public void deleteSMSJob(String jobId);

    /**
     * 查询短信任务
     * @param jobId
     * @return
     */
    public SMSJob getSMSJob(String jobId);

    /**
     * 分页查询短信任务
     * @param criteria
     * @return
     */
    public SMSJobCriteria getSMSJobList(SMSJobCriteria criteria);

    /**
     * 新建短信日志
     * @param log
     * @return
     */
    public SMSLog insertSMSLog(SMSLog log);

    /**
     * 更新短信日志
     * @param log
     * @return
     */
    public SMSLog updateSMSLog(SMSLog log);

    /**
     * 删除短信日志
     * @param log
     */
    public void deleteSMSLog(SMSLog log);

    /**
     * 删除短信日志
     * @param logId
     */
    public void deleteSMSLog(String logId);

    /**
     * 查询短信日志
     * @param logId
     * @return
     */
    public SMSLog getSMSLog(String logId);

    /**
     * 分页查询短信日志
     * @param criteria
     * @return
     */
    public SMSLogCriteria getSMSLogList(SMSLogCriteria criteria);
    
    /**
     * 查询短信日志总记录数
     * @param criteria
     * @return
     */
    int getSMSLogTotal(SMSLogCriteria criteria);

    /**
     * 处理短信任务
     * @param flag
     * @param job
     */
    public void dealSMSJob(boolean flag, SMSJob job);
   
    /**
     * 获取调度任务数据
     * @param criteria
     * @return
     */
    public List<SMSJob> getSchedulerSMSJobList(SMSJobCriteria criteria);
    
    /**
     * 处理上行短信
     * @param replyList
     * @return
     */
    public boolean dealSMSReply(List<SMSReply> replyList);
    
}
