package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.mmsResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfMmsIDListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.StringUtils;

public class mms_Send {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static String addNum;						//��չ�Ӻţ������ڶ˿ںź�
	private static String timer = "";					//��ʱʱ�䣺yyyy-MM-dd HH:mm:ss ��:2010-05-14 10:30:00 
	private static MobileListGroup[] mobileList;		//���պ����б�
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static ArrayOfMmsIDListHolder mmsIDList;	//����ID�б?���ڷ��ط��ͳɹ��Ĳ��ż�¼ID���˲���ID������״̬����ƥ���ʶ��
	private static LongHolder count ;					//���÷��ͷ�����ص�״ֵ̬
	
	public static mmsResultBean SendMsg(String mobiles,long mmsFileID){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		mmsIDList = new ArrayOfMmsIDListHolder();
		count = new LongHolder();
		mmsResultBean mmsBean = new mmsResultBean();
		
		//��ȡ�ʺ���Ϣ
		DataObjectBean bean = DataObjectFactory.getInstance();
		corpID = new Long(bean.getCordId());
		loginName = bean.getUserName();
		password = bean.getPasswd();
		
		//���ֻ�����ַ�ֽ⵽������
		String [] mobileArray= StringUtils.replace(mobiles, "��", ";").split(";");
		mobileList = new MobileListGroup[mobileArray.length];
		
		for (int i = 0;i<mobileList.length;i++) {
			mobileList[i] = new MobileListGroup();
			mobileList[i].setMobile(mobileArray[i]);
		}
		
		//MD5�������
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID+password+timeStamp);
		
		try {
			System.out.println(mobset);
			mobset.mms_Send(corpID, loginName, password, timeStamp, addNum, timer, mobileList, mmsFileID, count, errMsg, mmsIDList);
			mmsBean.setErrMsg(errMsg);
			mmsBean.setMmsIDList(mmsIDList);
			
			System.out.println(errMsg.value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mmsBean;
	}
}
