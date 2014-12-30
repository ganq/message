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
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsRecvListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class sms_GetRecv {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static ArrayOfSmsRecvListHolder smsRecvList;//���ж����б?���ڷ��ؽ��յ��Ķ������ݡ�ÿ����෵��20�����ж��š�
	private static LongHolder count;					//�������ж��ŵ����������ŵ����Դ�SmsRecvList�л�ȡ��

	public static msmResultBean getRecv(){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		count = new LongHolder();
		smsRecvList = new ArrayOfSmsRecvListHolder();
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
			for(int i=0;i<20;i++){
				mobset.sms_GetRecv(corpID, loginName, password, timeStamp, count, errMsg, smsRecvList);
				msmBean.setErrMsg(errMsg);
				msmBean.setSmsRecvList(smsRecvList);
				
				if (smsRecvList.value!=null && smsRecvList.value.length>0){
					break;
				}
				Thread.sleep(5);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msmBean;
	}
}
