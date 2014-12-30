/**
 * MobsetApiSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri;

public interface MobsetApiSoap extends java.rmi.Remote {

    /**
     * 发送短信
     */
    public void sms_Send(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, java.lang.String addNum, java.lang.String timer, long longSms, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup[] mobileList, java.lang.String content, javax.xml.rpc.holders.LongHolder count, javax.xml.rpc.holders.StringHolder errMsg, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsIDListHolder smsIDList) throws java.rmi.RemoteException;

    /**
     * 取上行短信
     */
    public void sms_GetRecv(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, javax.xml.rpc.holders.LongHolder count, javax.xml.rpc.holders.StringHolder errMsg, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsRecvListHolder smsRecvList) throws java.rmi.RemoteException;

    /**
     * 取短信状态报告
     */
    public void sms_GetReport(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, javax.xml.rpc.holders.LongHolder count, javax.xml.rpc.holders.StringHolder errMsg, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsReportListHolder smsReportList) throws java.rmi.RemoteException;

    /**
     * 取短信签名
     */
    public void sms_GetSign(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, javax.xml.rpc.holders.LongHolder errCode, javax.xml.rpc.holders.StringHolder errMsg, javax.xml.rpc.holders.StringHolder sign) throws java.rmi.RemoteException;

    /**
     * 取短信可用余额
     */
    public void sms_GetBalance(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, javax.xml.rpc.holders.LongHolder balance, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 上传彩信文件
     */
    public void mms_UpFile(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, java.lang.String subject, long smilType, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsFileGroup[] mmsFileList, javax.xml.rpc.holders.LongHolder mmsFileID, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 查询彩信文件状态
     */
    public void mms_GetFileStatus(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long mmsFileID, javax.xml.rpc.holders.LongHolder status, javax.xml.rpc.holders.StringHolder errMsg, javax.xml.rpc.holders.StringHolder title, javax.xml.rpc.holders.LongHolder size, javax.xml.rpc.holders.StringHolder createTime) throws java.rmi.RemoteException;

    /**
     * 发送彩信
     */
    public void mms_Send(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, java.lang.String addNum, java.lang.String timer, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup[] mobileList, long mmsFileID, javax.xml.rpc.holders.LongHolder count, javax.xml.rpc.holders.StringHolder errMsg, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsIDListHolder mmsIDList) throws java.rmi.RemoteException;

    /**
     * 取彩信状态
     */
    public void mms_GetReport(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, javax.xml.rpc.holders.LongHolder count, javax.xml.rpc.holders.StringHolder errMsg, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsReportListHolder mmsReportList) throws java.rmi.RemoteException;

    /**
     * 取彩信上行
     */
    public void mms_GetRecv(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, javax.xml.rpc.holders.LongHolder count, javax.xml.rpc.holders.StringHolder errMsg, javax.xml.rpc.holders.StringHolder mobile, javax.xml.rpc.holders.StringHolder recvNum, javax.xml.rpc.holders.StringHolder addNum, javax.xml.rpc.holders.StringHolder subject, javax.xml.rpc.holders.StringHolder recvTime, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsRecvFileGroupHolder mmsRecvFileList) throws java.rmi.RemoteException;

    /**
     * 上传号码文件
     */
    public void task_UpFile(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, java.lang.String subject, long autoDelete, byte[] fileData, javax.xml.rpc.holders.LongHolder taskFileID, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 删除号码文件
     */
    public void task_DelFile(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskFileID, javax.xml.rpc.holders.LongHolder errCode, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 提交短信任务
     */
    public void task_SmsSend(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, java.lang.String content, long longSms, long priority, java.lang.String atTime, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileFileGroup[] mobileList, javax.xml.rpc.holders.LongHolder taskSmsID, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 取短信任务状态
     */
    public void task_GetSmsStatus(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskSmsID, javax.xml.rpc.holders.LongHolder status, javax.xml.rpc.holders.StringHolder errMsg, javax.xml.rpc.holders.LongHolder mobileCount, javax.xml.rpc.holders.LongHolder YFMobileCount, javax.xml.rpc.holders.StringHolder beginTime, javax.xml.rpc.holders.StringHolder endTime) throws java.rmi.RemoteException;

    /**
     * 停止短信任务
     */
    public void task_SmsStop(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskSmsID, javax.xml.rpc.holders.LongHolder errCode, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 启动短信任务
     */
    public void task_SmsStart(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskSmsID, javax.xml.rpc.holders.LongHolder errCode, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 提交彩信任务
     */
    public void task_MmsSend(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long mmsFileID, long priority, java.lang.String atTime, com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileFileGroup[] mobileList, javax.xml.rpc.holders.LongHolder taskMmsID, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 取彩信任务状态
     */
    public void task_GetMmsStatus(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskMmsID, javax.xml.rpc.holders.LongHolder status, javax.xml.rpc.holders.StringHolder errMsg, javax.xml.rpc.holders.LongHolder mobileCount, javax.xml.rpc.holders.LongHolder YFMobileCount, javax.xml.rpc.holders.StringHolder beginTime, javax.xml.rpc.holders.StringHolder endTime) throws java.rmi.RemoteException;

    /**
     * 停止彩信任务
     */
    public void task_MmsStop(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskMmsID, javax.xml.rpc.holders.LongHolder errCode, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;

    /**
     * 启动彩信任务
     */
    public void task_MmsStart(long corpID, java.lang.String loginName, java.lang.String password, java.lang.String timeStamp, long taskMmsID, javax.xml.rpc.holders.LongHolder errCode, javax.xml.rpc.holders.StringHolder errMsg) throws java.rmi.RemoteException;
}
