package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.taskResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileFileGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class task_SmsSend {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static long longSms = 0;					//�Ƿ��Գ����ŷ�ʽ����,0-��1-��
	private static String atTime = "2010-05-14 10:30:00";//��ʱʱ�䣺yyyy-MM-dd HH:mm:ss ��:2010-05-14 10:30:00
	private static long priority = 0;					//���ȼ�0-100�����С������ߡ�
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder taskSmsID ;				//�ύ�������񣬷��ض�������ID(TaskSmsID)
	
	public static taskResultBean taskSmsSend(MobileFileGroup[] mobileList,String content){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		taskSmsID = new LongHolder();
		taskResultBean taskBean = new taskResultBean();
		
		//��ȡ�ʺ���Ϣ
		DataObjectBean bean = DataObjectFactory.getInstance();
		corpID = new Long(bean.getCordId());
		loginName = bean.getUserName();
		password = bean.getPasswd();
		
		//MD5�������
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID+password+timeStamp);
		
		try {
			mobset.task_SmsSend(corpID, loginName, password, timeStamp, content, longSms, priority, atTime, mobileList, taskSmsID, errMsg);
			taskBean.setErrMsg(errMsg);
			taskBean.setTaskSmsID(taskSmsID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskBean;
	}
}
