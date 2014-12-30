/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sms;

import java.sql.DatabaseMetaData;
import java.util.Date;

import com.mysoft.b2b.bizsupport.api.util.AbstractCriteria;

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

@SuppressWarnings("serial")
public class SMSLogCriteria extends AbstractCriteria<SMSLog> {
    
    /**
     * 消息批次
     */
    private String messageBatch;

    /**
     * 类型编码
     */
    private String messageTypeCode;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 发送者ID
     */
    private String senderId;

    /**
     * 接收者列表JSON，包括ID，名称和接收地址
     */
    private String receiver;

    /**
     * 状态：3发送成功;
     */
    private int status;
    
    private Date lastSentTime;
    /**
     * 当前日期时间（用于验证码统计当天发送短信次数）
     */
    private Date currentDateTime;
    
    public String getMessageBatch() {
        return messageBatch;
    }

    public void setMessageBatch(String messageBatch) {
        this.messageBatch = messageBatch;
    }

    public String getMessageTypeCode() {
        return messageTypeCode;
    }

    public void setMessageTypeCode(String messageTypeCode) {
        this.messageTypeCode = messageTypeCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastSentTime() {
        return lastSentTime;
    }

    public void setLastSentTime(Date lastSentTime) {
        this.lastSentTime = lastSentTime;
    }

	public Date getCurrentDateTime() {
		return currentDateTime;
	}
	
	public void setCurrentDateTime(Date currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

}
