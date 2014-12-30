/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.queue;

import java.io.Serializable;
import java.util.Date;

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

@SuppressWarnings("serial")
public class MessageQueue implements Serializable {

    /**
     * 數據庫主鍵
     */
    private String queueId;

    /**
     * 消息批次
     */
    private String messageBatch;

    /**
     * 消息类型编码
     */
    private String messageTypeCode;

    /**
     * 标题
     */
    private String title;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 发送者ID
     */
    private String senderId;

    /**
     * 通道
     */
    private String channel;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 内容
     */
    private String content;

    /**
     * 附件
     */
    private String attachments;

    /**
     * 状态
     */
    private Integer status = null;

    /**
     * 处理次数
     */
    private int tryTimes;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 处理时间
     */
    private Date dealtTime;
    
    private String remark;

	public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(int tryTimes) {
        this.tryTimes = tryTimes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getDealtTime() {
        return dealtTime;
    }

    public void setDealtTime(Date dealtTime) {
        this.dealtTime = dealtTime;
    }

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
	public String toString() {
		return "MessageQueue [queueId=" + queueId + ", messageBatch="
				+ messageBatch + ", messageTypeCode=" + messageTypeCode
				+ ", title=" + title + ", sender=" + sender + ", senderId="
				+ senderId + ", channel=" + channel + ", receiver=" + receiver
				+ ", content=" + content + ", attachments=" + attachments
				+ ", status=" + status + ", tryTimes=" + tryTimes
				+ ", createdTime=" + createdTime + ", dealtTime=" + dealtTime
				+ ", remark=" + remark + "]";
	}

}
