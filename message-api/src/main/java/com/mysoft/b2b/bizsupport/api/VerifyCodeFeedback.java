package com.mysoft.b2b.bizsupport.api;

import java.io.Serializable;
import java.util.Date;

public class VerifyCodeFeedback implements Serializable {
	private static final long serialVersionUID = -6014498886780373962L;

	private String uid;
	private String token;
	private String verifyCode;
	private String mobile;
	private Date applyTime;
	private Integer status = new Integer(1);
	private String operatedBy;
	private Date operatedTime;
	private String remark;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOperatedBy() {
		return operatedBy;
	}

	public void setOperatedBy(String operatedBy) {
		this.operatedBy = operatedBy;
	}

	public Date getOperatedTime() {
		return operatedTime;
	}

	public void setOperatedTime(Date operatedTime) {
		this.operatedTime = operatedTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
