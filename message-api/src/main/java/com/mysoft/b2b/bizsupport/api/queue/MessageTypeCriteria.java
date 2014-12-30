/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.queue;

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
public class MessageTypeCriteria extends AbstractCriteria<MessageType> {

    private String messageTypeCode;
    
    private String title;

    private String channel;
    
    private List<String> typeCodeList;

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

	@Override
	public String toString() {
		return "MessageTypeCriteria [messageTypeCode=" + messageTypeCode
				+ ", title=" + title + ", channel=" + channel + ", offset="
				+ offset + ", pageSize=" + pageSize + ", currentPage="
				+ currentPage + ", totalRows=" + totalRows + ", list=" + list
				+ "]";
	}

	/**
	 * @return the typeCodeList
	 */
	public List<String> getTypeCodeList() {
		return typeCodeList;
	}

	/**
	 * @param typeCodeList the typeCodeList to set
	 */
	public void setTypeCodeList(List<String> typeCodeList) {
		this.typeCodeList = typeCodeList;
	}

}
