package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.mmsResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.taskResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class task_DelFile {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder errCode ;					//����ɾ���ļ���״̬
	
	public static taskResultBean taskDelFile(long taskFileID){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		errCode = new LongHolder();
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
			mobset.task_DelFile(corpID, loginName, password, timeStamp, taskFileID, errCode, errMsg);
			taskBean.setErrMsg(errMsg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskBean;
	}
}
