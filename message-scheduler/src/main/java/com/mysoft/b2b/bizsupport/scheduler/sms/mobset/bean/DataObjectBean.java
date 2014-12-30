package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean;

public class DataObjectBean {
	
	private String cordId; // ��ҵID
	
	private String userName;// ȡ����
	
	private String passwd; //����

	private String serverIP; // ������IP

	public String getCordId() {
		return cordId;
	}

	public void setCordId(String cordId) {
		this.cordId = cordId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public DataObjectBean() {
		super();
	}

	public DataObjectBean(String cordId, String userName, String passwd,
			String serverIP) {
		super();
		this.cordId = cordId;
		this.userName = userName;
		this.passwd = passwd;
		this.serverIP = serverIP;
	}

}
