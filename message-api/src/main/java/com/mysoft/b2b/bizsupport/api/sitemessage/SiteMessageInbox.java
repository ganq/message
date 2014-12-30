/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sitemessage;

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
public class SiteMessageInbox implements Serializable {

    /**
     * 
     */
    private String inboxId;

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
     * 发送者ID
     */
    private String senderId;

    /**
     * 接收者列表JSON，包括ID，名称和接收地址
     */
    private String receiver;
    
    private String receiverId;
    
    private Date receivedTime;
    
    private Date readedTime;

    /**
     * 是否删除
     */
    private Boolean isDeleted;
    
    /**
     * 是否已读
     */
    private Boolean isReaded;


    
    public Boolean isReaded() {
		return isReaded;
	}

	public void setReaded(Boolean isReaded) {
		this.isReaded = isReaded;
	}

	public String getInboxId() {
		return inboxId;
	}

	public void setInboxId(String inboxId) {
		this.inboxId = inboxId;
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

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public Date getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}

	public Date getReadedTime() {
		return readedTime;
	}

	public void setReadedTime(Date readedTime) {
		this.readedTime = readedTime;
	}

}
