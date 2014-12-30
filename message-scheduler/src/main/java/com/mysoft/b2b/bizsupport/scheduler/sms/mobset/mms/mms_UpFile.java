package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.mmsResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.msmResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsFileGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;
/**
 * ���Ų���
 * smilType :����Smil�ļ�����:
			0-��ƽ̨�Զ����Smil�ļ�
			1-�����ļ��а�Smil�ļ�(����Ϊ��һ��MmsFileGroup�е�Text�ļ�)
			2-����Smil�ļ�
*/
public class mms_UpFile {
	private static long corpID;      					//��ҵID
	private static String loginName;					//��¼�ʺ�
	private static String password;						//���룬MD5(CorpID+�ʺ�����+TimeStamp)
	private static String timeStamp = "0514094912";		//ʱ�����MMDDHHMMSS������ʱ����),��0514094912
	private static long smilType = 0;					//����Smil�ļ�����:
	private static StringHolder errMsg;					//������Ϣ�����ڷ��غ�����ý�����������
	private static LongHolder mmsFileID ;				//�����ļ�ID�����ز����ļ�ID
	
	public static mmsResultBean MmsUpFile(String subject,MmsFileGroup[] mmsFileList){
		
		//���ʵ����󼰳�ʼ������
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		timeStamp = formatter.format(aDate); 
		errMsg = new StringHolder();
		mmsFileID = new LongHolder();
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
			mobset.mms_UpFile(corpID, loginName, password, timeStamp, subject, smilType, mmsFileList, mmsFileID, errMsg);
			mmsBean.setErrMsg(errMsg);
			mmsBean.setMmsFileID(mmsFileID);
			System.out.println(errMsg.value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mmsBean;
	}
}
