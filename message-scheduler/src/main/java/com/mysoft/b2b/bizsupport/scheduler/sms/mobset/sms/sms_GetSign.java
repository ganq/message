package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.msmResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class sms_GetSign {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder errCode;					//���ػ�ȡǩ���״ֵ̬
	private static StringHolder sign;					//����ǩ�����ڷ��ش��ʺ������õĶ���ǩ��

	public static msmResultBean getSign(){
		
		//���ʵ�����
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		errCode = new LongHolder();
		sign = new StringHolder();
		msmResultBean msmBean = new msmResultBean();
		
		//��ȡ�ʺ���Ϣ
		DataObjectBean bean = DataObjectFactory.getInstance();
		corpID = new Long(bean.getCordId());
		loginName = bean.getUserName();
		password = bean.getPasswd();
		
		//MD5�������
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID+password+timeStamp);
		
		try {
				mobset.sms_GetSign(corpID, loginName, password, timeStamp, errCode, errMsg, sign);
				msmBean.setErrMsg(errMsg);
				msmBean.setErrCode(errCode);
				msmBean.setSign(sign);
				
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msmBean;
	}
}
