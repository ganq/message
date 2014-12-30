package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.taskResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;

public class task_GetSmsStatus {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder status ;					//����ȡ��������״̬
	private static LongHolder mobileCount ;				//�ֻ�����������ڷ��ش�������ֻ��������
	private static LongHolder YFMobileCount ;			//�ѷ��������������ڷ��ش�������ѷ����������
	private static StringHolder beginTime;				//���ر�����ʼʱ�䣬��ʽ�磺2010-05-14 10:30:00������δ��ʼ����ʱ��Ϊ�ա�
	private static StringHolder endTime;				//���ر��������ʱ�䣬��ʽ�磺2010-05-14 10:30:00������δ������ʱ��Ϊ�ա�
	
	public static taskResultBean taskGetSmsStatus(long taskSmsID){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		status = new LongHolder();
		mobileCount = new LongHolder();
		YFMobileCount = new LongHolder();
		beginTime = new StringHolder();
		endTime = new StringHolder();
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
			mobset.task_GetSmsStatus(corpID, loginName, password, timeStamp, taskSmsID, status, errMsg, mobileCount, YFMobileCount, beginTime, endTime);
			taskBean.setErrMsg(errMsg);
			taskBean.setStatus(status);
			taskBean.setMobileCount(mobileCount);
			taskBean.setYFMobileCount(YFMobileCount);
			taskBean.setBeginTime(beginTime);
			taskBean.setEndTime(endTime);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskBean;
	}
}
