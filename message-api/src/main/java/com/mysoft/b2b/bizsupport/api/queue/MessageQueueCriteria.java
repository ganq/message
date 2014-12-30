/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.queue;

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
public class MessageQueueCriteria extends AbstractCriteria<MessageQueue> {

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
     * 状态
     */
    private Integer status = null;

    private List<Integer> statuss;

    /**
     * 处理次数
     */
    private int tryTimes;

    /**
     * 处理时间
     */
    private Date dealtTime;
    
    /**
     * 创建时间
     */
    private Date createdTime;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getStatuss() {
        return statuss;
    }

    public void setStatuss(List<Integer> statuss) {
        this.statuss = statuss;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(int tryTimes) {
        this.tryTimes = tryTimes;
    }

    public Date getDealtTime() {
        return dealtTime;
    }

    public void setDealtTime(Date dealtTime) {
        this.dealtTime = dealtTime;
    }

    @Override
    public String toString() {
        return "MessageQueueCriteria [messageBatch=" + messageBatch + ", messageTypeCode=" + messageTypeCode + ", title=" + title
                + ", sender=" + sender + ", senderId=" + senderId + ", channel=" + channel + ", receiver=" + receiver + ", content="
                + content + ", status=" + status + ", pageSize=" + pageSize + ", currentPage=" + currentPage + ", totalRows=" + totalRows
                + ", list=" + list + ", offset=" + offset + "]";
    }

	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}
