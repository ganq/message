package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileFileGroup;


public class taskResultBean {
	private StringHolder errMsg;
	private StringHolder subject;
	private LongHolder taskFileID;
	private long autoDelete;
	private LongHolder taskSmsID ;
	private MobileFileGroup[] mobileList;
	private LongHolder status ;
	private LongHolder mobileCount ;
	private LongHolder YFMobileCount ;
	private StringHolder beginTime;
	private StringHolder endTime;
	
	public LongHolder getStatus() {
		return status;
	}
	public void setStatus(LongHolder status) {
		this.status = status;
	}
	public LongHolder getMobileCount() {
		return mobileCount;
	}
	public void setMobileCount(LongHolder mobileCount) {
		this.mobileCount = mobileCount;
	}
	public LongHolder getYFMobileCount() {
		return YFMobileCount;
	}
	public void setYFMobileCount(LongHolder yFMobileCount) {
		YFMobileCount = yFMobileCount;
	}
	public StringHolder getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(StringHolder beginTime) {
		this.beginTime = beginTime;
	}
	public StringHolder getEndTime() {
		return endTime;
	}
	public void setEndTime(StringHolder endTime) {
		this.endTime = endTime;
	}
	public LongHolder getTaskSmsID() {
		return taskSmsID;
	}
	public void setTaskSmsID(LongHolder taskSmsID) {
		this.taskSmsID = taskSmsID;
	}
	public MobileFileGroup[] getMobileList() {
		return mobileList;
	}
	public void setMobileList(MobileFileGroup[] mobileList) {
		this.mobileList = mobileList;
	}
	public StringHolder getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(StringHolder errMsg) {
		this.errMsg = errMsg;
	}
	public StringHolder getSubject() {
		return subject;
	}
	public void setSubject(StringHolder subject) {
		this.subject = subject;
	}
	public LongHolder getTaskFileID() {
		return taskFileID;
	}
	public void setTaskFileID(LongHolder taskFileID) {
		this.taskFileID = taskFileID;
	}
	public long getAutoDelete() {
		return autoDelete;
	}
	public void setAutoDelete(long autoDelete) {
		this.autoDelete = autoDelete;
	}
	public taskResultBean() {
		super();
	}
	public taskResultBean(StringHolder subject,StringHolder errMsg, LongHolder taskFileID) {
		super();
		this.subject = subject;
		this.errMsg = errMsg;
		this.taskFileID = taskFileID;
	}
}
