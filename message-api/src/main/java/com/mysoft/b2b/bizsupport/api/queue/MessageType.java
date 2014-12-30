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
public class MessageType implements Serializable {

    private String messageTypeId;
    
    private String messageTypeCode;
    
    private String title;

    private String channel;

    private String remark;

    private String createdBy;

    private Date createTime;

    private String lastModifiedBy;

    private Date lastModifiedTime;

    public String getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(String messageTypeId) {
        this.messageTypeId = messageTypeId;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

	@Override
	public String toString() {
		return "MessageType [messageTypeId=" + messageTypeId
				+ ", messageTypeCode=" + messageTypeCode + ", title=" + title
				+ ", channel=" + channel + ", remark=" + remark
				+ ", createdBy=" + createdBy + ", createTime=" + createTime
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedTime="
				+ lastModifiedTime + "]";
	}

    
}
