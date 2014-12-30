package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.mmsResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsFileGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class mms_GetFileStatus {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder status ;					//����ȡ�����ļ�״̬��0-ȡ�����ļ�״̬�ɹ�
	private static StringHolder title;					//���ű��⣬���ڷ��ز��ű���
	private static LongHolder size ;					//���Ŵ�С�����ڷ��ز��Ŵ�С
	private static StringHolder createTime;				//���Ŵ���ʱ�䣬���ڷ��ز��Ŵ�����ʱ�䣬��ʽ�磺2010-05-14 10:30:00
	
	public static mmsResultBean GetFileStatus(long mmsFileID){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		status = new LongHolder();
		title = new StringHolder();
		size = new LongHolder();
		createTime = new StringHolder();
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
			mobset.mms_GetFileStatus(corpID, loginName, password, timeStamp, mmsFileID, status, errMsg, title, size, createTime);
			mmsBean.setErrMsg(errMsg);
			mmsBean.setStatus(status);
			mmsBean.setCreateTime(createTime);
			mmsBean.setSize(size);
			mmsBean.setStatus(status);
			mmsBean.setTitle(title);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mmsBean;
	}
}
