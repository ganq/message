/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sms;

import java.util.Date;
import java.util.List;

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
public class SMSJobCriteria extends AbstractCriteria<SMSJob> {
    

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
    
    private List<Integer> statuss;
    
    private Date lastSentTime;
    
    private int tryTimes;

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

    public List<Integer> getStatuss() {
        return statuss;
    }

    public void setStatuss(List<Integer> statuss) {
        this.statuss = statuss;
    }

    public Date getLastSentTime() {
        return lastSentTime;
    }

    public void setLastSentTime(Date lastSentTime) {
        this.lastSentTime = lastSentTime;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(int tryTimes) {
        this.tryTimes = tryTimes;
    }
    
}
