package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.mmsResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsReportGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsIDListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsReportListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.StringUtils;

public class mms_GetReport {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder count ;					//���ø÷����ķ���ֵ��ȡ����״̬����
	private static ArrayOfMmsReportListHolder mmsReportList;//����״̬�����б?���ڷ��ؽ��յ��Ĳ���״̬���档ÿ����෵��50��״̬���档
	
	public static mmsResultBean getReport(String mmsIDs){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		count = new LongHolder();
		mmsReportList = new ArrayOfMmsReportListHolder();
		mmsResultBean mmsBean = new mmsResultBean();
		
		//��ȡ�ʺ���Ϣ
		DataObjectBean bean = DataObjectFactory.getInstance();
		corpID = new Long(bean.getCordId());
		loginName = bean.getUserName();
		password = bean.getPasswd();
		
		//MD5�������
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID+password+timeStamp);
		
		try {
			System.out.println(mmsReportList.value);
			mobset.mms_GetReport(corpID, loginName, password, timeStamp, count, errMsg, mmsReportList);
			mmsBean.setErrMsg(errMsg);
			if(mmsReportList != null)
			mmsBean.setMmsReportList(mmsReportList);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mmsBean;
	}
}
