/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.email;

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
public class EmailLogCriteria extends AbstractCriteria<EmailLog> {

    private String messageBatch;
    
    private String messageTypeCode;
    
    private int status;

    private String title;

    private String content;

    private String sender;

    private String receiver;
    
    /**
     * 最后发送时间
     */
    private Date lastSentTime;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
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

	/**
	 * @return the lastSentTime
	 */
	public Date getLastSentTime() {
		return lastSentTime;
	}

	/**
	 * @param lastSentTime the lastSentTime to set
	 */
	public void setLastSentTime(Date lastSentTime) {
		this.lastSentTime = lastSentTime;
	}
    
}
