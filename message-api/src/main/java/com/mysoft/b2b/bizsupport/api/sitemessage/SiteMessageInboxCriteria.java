/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sitemessage;

import java.util.Date;
import java.util.List;

import com.mysoft.b2b.bizsupport.api.util.AbstractCriteria;

/**
 * Update 2014-09-04 新增关键字、类型集合字段
 * 
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
public class SiteMessageInboxCriteria extends AbstractCriteria<SiteMessageInbox> {
	/**
	 * 消息id
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

    /**
     * 是否删除
     */
    private Boolean isDeleted;
    
    /**
     * 是否删除
     */
    private Boolean isReaded;

	/**
     *  消息发送时间(起始)
     */
    private Date sentBeginTime;
    
    /**
     *  消息发送时间(截止)
     */
    private Date sentEndTime;
    
    /**
     *  消息接受时间
     */
    private Date receivedTime;
    
    /**
     * 关键字（title、content）
     */
    private String keyword;
    /**
     * 消息类型集合
     */
    private List<String> typeCodeList;
    /**
     * 用户Id (临时字段 用于获取发送个人的数据)
     */
    private String userId;
    /**
     * 公司Id (临时字段 用于获取发送公司的数据)
     */
    private String companyId;
    
    
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

    public Date getSentBeginTime() {
        return sentBeginTime;
    }

    public void setSentBeginTime(Date sentBeginTime) {
        this.sentBeginTime = sentBeginTime;
    }

    public Date getSentEndTime() {
        return sentEndTime;
    }

    public void setSentEndTime(Date sentEndTime) {
        this.sentEndTime = sentEndTime;
    }

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsReaded() {
		return isReaded;
	}

	public void setIsReaded(Boolean isReaded) {
		this.isReaded = isReaded;
	}

	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<String> getTypeCodeList() {
		return typeCodeList;
	}

	public void setTypeCodeList(List<String> typeCodeList) {
		this.typeCodeList = typeCodeList;
	}

	public String getInboxId() {
		return inboxId;
	}

	public void setInboxId(String inboxId) {
		this.inboxId = inboxId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the receivedTime
	 */
	public Date getReceivedTime() {
		return receivedTime;
	}

	/**
	 * @param receivedTime the receivedTime to set
	 */
	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}
	
}
