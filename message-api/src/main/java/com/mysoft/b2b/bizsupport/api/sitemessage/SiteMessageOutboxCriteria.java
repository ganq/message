/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sitemessage;

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
public class SiteMessageOutboxCriteria extends AbstractCriteria<SiteMessageOutbox> {

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
     * 附件列表，拼接字符串
     */
    private String attachments;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 发送者Id
     */
    private String senderId;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 接收者Id
     */
    private String receiverId;

    /**
     * 状态，0：未读，1：已读
     */
    private Boolean isReaded;

    /**
     * 是否删除，0：正常，1：删除
     */
    private Boolean isDeleted;
    
    /**
     *  消息接收时间(起始)
     */
    private Date receivedBeginTime;
    
    /**
     *  消息接收时间(截止)
     */
    private Date receivedEndTime;

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

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getSender() {
        return sender;
    }
    
    public Boolean getIsReaded() {
		return isReaded;
	}

	public void setIsReaded(Boolean isReaded) {
		this.isReaded = isReaded;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Date getReceivedBeginTime() {
        return receivedBeginTime;
    }

    public void setReceivedBeginTime(Date receivedBeginTime) {
        this.receivedBeginTime = receivedBeginTime;
    }

    public Date getReceivedEndTime() {
        return receivedEndTime;
    }

    public void setReceivedEndTime(Date receivedEndTime) {
        this.receivedEndTime = receivedEndTime;
    }

}
