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
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class task_MmsSend {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static String atTime = "2010-05-14 10:30:00";//��ʱʱ�䣺yyyy-MM-dd HH:mm:ss ��:2010-05-14 10:30:00������ģʽ�£���ʱʱ�䲻�ɳ���1���¡�
	private static long priority = 0;					//���ȼ�0-100�����С������ߡ�
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder taskMmsID ;				//�ύ�������񣬷��ز�������ID(TaskMmsID)
	
	public static taskResultBean taskSmsSend(MobileFileGroup[] mobileList,long mmsFileID){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		taskMmsID = new LongHolder();
		taskResultBean taskBean = new taskResultBean();
		
		//���ʵ����󼰳�ʼ������
		DataObjectBean bean = DataObjectFactory.getInstance();
		corpID = new Long(bean.getCordId());
		loginName = bean.getUserName();
		password = bean.getPasswd();
		
		//MD5�������
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID+password+timeStamp);
		
		try {
			mobset.task_MmsSend(corpID, loginName, password, timeStamp, mmsFileID, priority, atTime, mobileList, taskMmsID, errMsg);
			taskBean.setErrMsg(errMsg);
			taskBean.setTaskSmsID(taskMmsID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskBean;
	}
}
