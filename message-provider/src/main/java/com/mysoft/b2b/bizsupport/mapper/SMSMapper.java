/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;
import java.util.Map;

import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.api.sms.SMSJobCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSLog;
import com.mysoft.b2b.bizsupport.api.sms.SMSLogCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSReply;

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

public interface SMSMapper {
    /**
     * 新建短信任务
     * @param job
     * @return
     */
    public void insertSMSJob(SMSJob job);

    /**
     * 更新短信任务
     * @param job
     * @return
     */
    public void updateSMSJob(SMSJob job);

    /**
     * 删除短信任务
     * @param jobId
     */
    public void deleteSMSJob(String jobId);

    /**
     * 查询短信任务
     * @param job
     * @return
     */
    public SMSJob getSMSJob(String jobId);

    /**
     * 分页查询短信任务
     * @param criteria
     * @return
     */
    public List<SMSJob> getSMSJobList(SMSJobCriteria criteria);
    
    public int getSMSJobTotal(SMSJobCriteria criteria);

    /**
     * 新建短信日志
     * @param job
     * @return
     */
    public void insertSMSLog(SMSLog job);

    /**
     * 更新短信日志
     * @param job
     * @return
     */
    public void updateSMSLog(SMSLog job);

    /**
     * 删除短信日志
     * @param logId
     */
    public void deleteSMSLog(String logId);

    /**
     * 查询短信日志
     * @param job
     * @return
     */
    public SMSLog getSMSLog(String logId);

    /**
     * 分页查询短信日志
     * @param criteria
     * @return
     */
    public List<SMSLog> getSMSLogList(SMSLogCriteria criteria);
    
    /**
     * 分页查询短信日志总数
     * @param criteria
     * @return
     */
    public int getSMSLogTotal(SMSLogCriteria criteria);

    /**
     * 获取调度任务数据
     * @param criteria
     * @return
     */
    public List<SMSJob> getSchedulerSMSJobList(SMSJobCriteria criteria);
    
    /**
     * 处理上行短信
     * 
     * @param smsReply
     * @return
     */
    int dealSMSReply(SMSReply smsReply);
    
	/**
	 * 是否已退订
	 * 
	 * @param email
	 * @return
	 */
	int isUnsubscribled(String mobile);
    
    /**
     * 通过手机号获取供应商信息
     * 
     * @param mobile
     * @return
     */
    Map<String, Object> getSupplierInfo(String mobile);
    
    /**
     * 通过手机号获取供应商信息
     * 
     * @param mobile
     * @return
     */
    Map<String, Object> getSupplierInfo2(String mobile);
    
}
