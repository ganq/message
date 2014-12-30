package com.mysoft.b2b.bizsupport.api.sms;

import java.io.Serializable;
import java.util.Date;

public class SMSReply  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String id;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 短信内容
	 */
	private String content;
	
	/**
	 * 收信时间，格式如：2010-05-14 10:30:00
	 */
	private Date recvTime;
	
	/**
	 * 接收号码，即短信发送时的目标号码
	 */
	private String recvNum;
	
	/**
	 * 创建筛检
	 */
	private Date createdTime;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 公司ID
	 */
	private String companyId;

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the recvTime
	 */
	public Date getRecvTime() {
		return recvTime;
	}

	/**
	 * @param recvTime the recvTime to set
	 */
	public void setRecvTime(Date recvTime) {
		this.recvTime = recvTime;
	}

	/**
	 * @return the recvNum
	 */
	public String getRecvNum() {
		return recvNum;
	}

	/**
	 * @param recvNum the recvNum to set
	 */
	public void setRecvNum(String recvNum) {
		this.recvNum = recvNum;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}
