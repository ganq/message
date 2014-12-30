package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsIDListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsReportListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsRecvListHolder;


public class mmsResultBean {
	private StringHolder errMsg;
	private LongHolder mmsFileID;
	private LongHolder status ;
	private StringHolder title;
	private LongHolder size ;
	private StringHolder createTime;
	private ArrayOfMmsIDListHolder mmsIDList;
	private ArrayOfMmsReportListHolder mmsReportList;
	
	public ArrayOfMmsReportListHolder getMmsReportList() {
		return mmsReportList;
	}
	public void setMmsReportList(ArrayOfMmsReportListHolder mmsReportList) {
		this.mmsReportList = mmsReportList;
	}
	public ArrayOfMmsIDListHolder getMmsIDList() {
		return mmsIDList;
	}
	public void setMmsIDList(ArrayOfMmsIDListHolder mmsIDList) {
		this.mmsIDList = mmsIDList;
	}
	public StringHolder getTitle() {
		return title;
	}
	public void setTitle(StringHolder title) {
		this.title = title;
	}
	public LongHolder getSize() {
		return size;
	}
	public void setSize(LongHolder size) {
		this.size = size;
	}
	public StringHolder getCreateTime() {
		return createTime;
	}
	public void setCreateTime(StringHolder createTime) {
		this.createTime = createTime;
	}
	public LongHolder getStatus() {
		return status;
	}
	public void setStatus(LongHolder status) {
		this.status = status;
	}
	public StringHolder getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(StringHolder errMsg) {
		this.errMsg = errMsg;
	}
	public LongHolder getMmsFileID() {
		return mmsFileID;
	}
	public void setMmsFileID(LongHolder mmsFileID) {
		this.mmsFileID = mmsFileID;
	}
	public mmsResultBean() {
		super();
	}
	public mmsResultBean(StringHolder errMsg, LongHolder mmsFileID) {
		super();
		this.errMsg = errMsg;
		this.mmsFileID = mmsFileID;
	}
}
