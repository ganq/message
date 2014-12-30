package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.msmResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.SmsReportGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsIDListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsReportListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.StringUtils;

public class sms_GetReport {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static ArrayOfSmsReportListHolder smsReportList;//����״̬�����б?���ڷ��ؽ��յ��Ķ���״̬���档ÿ����෵��50��״̬���档
	private static LongHolder count;					//���ú���ķ���ֵ�����Ͷ��ţ����ض���ID(SmsID)
	
	public static msmResultBean getReport(String reportList){
		
		//���ʵ�����
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		count = new LongHolder();
		msmResultBean msmBean = new msmResultBean();
		smsReportList = new ArrayOfSmsReportListHolder();
		
		//��ȡ�ʺ���Ϣ
		DataObjectBean bean = DataObjectFactory.getInstance();
		corpID = new Long(bean.getCordId());
		loginName = bean.getUserName();
		password = bean.getPasswd();
		
		//MD5�������
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID+password+timeStamp);
		
		try {
			mobset.sms_GetReport(corpID, loginName, password,timeStamp,count,errMsg, smsReportList);
			msmBean.setErrMsg(errMsg);
			if(smsReportList != null)
			msmBean.setSmsReportList(smsReportList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msmBean;
	}
}
