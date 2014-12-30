package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsIDListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsRecvListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsReportListHolder;

public class msmResultBean {
	private StringHolder errMsg;
	private ArrayOfSmsIDListHolder smsIDList;
	private MobileListGroup[] mobileList;
	private ArrayOfSmsReportListHolder smsReportList;
	private ArrayOfSmsRecvListHolder smsRecvList;
	private LongHolder balance;
	private StringHolder sign;
	private LongHolder errCode;
	
	public LongHolder getErrCode() {
		return errCode;
	}
	public void setErrCode(LongHolder errCode) {
		this.errCode = errCode;
	}
	public StringHolder getSign() {
		return sign;
	}
	public void setSign(StringHolder sign) {
		this.sign = sign;
	}
	public LongHolder getBalance() {
		return balance;
	}
	public void setBalance(LongHolder balance) {
		this.balance = balance;
	}
	public ArrayOfSmsRecvListHolder getSmsRecvList() {
		return smsRecvList;
	}
	public void setSmsRecvList(ArrayOfSmsRecvListHolder smsRecvList) {
		this.smsRecvList = smsRecvList;
	}
	public ArrayOfSmsReportListHolder getSmsReportList() {
		return smsReportList;
	}
	public void setSmsReportList(ArrayOfSmsReportListHolder smsReportList) {
		this.smsReportList = smsReportList;
	}
	public StringHolder getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(StringHolder errMsg) {
		this.errMsg = errMsg;
	}
	public ArrayOfSmsIDListHolder getSmsIDList() {
		return smsIDList;
	}
	public void setSmsIDList(ArrayOfSmsIDListHolder smsIDList) {
		this.smsIDList = smsIDList;
	}
	public MobileListGroup[] getMobileList() {
		return mobileList;
	}
	public void setMobileList(MobileListGroup[] mobileList) {
		this.mobileList = mobileList;
	}
	public msmResultBean() {
		super();
	}

	public msmResultBean(StringHolder errMsg, ArrayOfSmsIDListHolder smsIDList, MobileListGroup[] mobileList) {
		super();
		this.errMsg = errMsg;
		this.smsIDList = smsIDList;
		this.mobileList = mobileList;
	}
}
