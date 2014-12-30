/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.email;

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
public class EmailJob implements Serializable {

    private String emailJobId;

    private String messageBatch;

    private String messageTypeCode;

    private String title;

    private String content;

    private String attachments;

    private String sender;

    private String senderId;

    private String receiver;

    private int status;

    private String remark;

    private int tryTimes;

    private Date createdTime;

    private Date lastSentTime;

    public String getEmailJobId() {
        return emailJobId;
    }

    public void setEmailJobId(String emailJobId) {
        this.emailJobId = emailJobId;
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

    public Date getLastSentTime() {
        return lastSentTime;
    }

    public void setLastSentTime(Date lastSentTime) {
        this.lastSentTime = lastSentTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public EmailLog getEmailLog() {
        EmailLog log = new EmailLog();
        log.setEmailLogId(emailJobId);
        log.setMessageBatch(messageBatch);
        log.setTitle(title);
        log.setMessageTypeCode(messageTypeCode);
        log.setContent(content);
        log.setAttachments(attachments);
        log.setSender(sender);
        log.setSenderId(senderId);
        log.setReceiver(receiver);
        log.setStatus(status);
        log.setRemark(remark);
        log.setTryTimes(tryTimes);
        log.setCreatedTime(createdTime);
        log.setLastSentTime(lastSentTime);
        return log;
    }

}
