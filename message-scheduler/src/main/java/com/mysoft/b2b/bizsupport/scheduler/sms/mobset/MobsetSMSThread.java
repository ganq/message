/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.sms.mobset;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.mysoft.b2b.bizsupport.api.sms.SMSReply;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.msmResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileListGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.SmsRecvGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsIDListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsRecvListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.MD5;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.AbstractThread;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.ReplyResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.SMSMessageBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.SMSOperationEnum;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.SendResultReceipt;
import com.mysoft.b2b.commons.exception.PlatformUncheckException;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public class MobsetSMSThread extends AbstractThread {

	private static long corpID;      					//企业ID
	private static String loginName;					//登录帐号
	private static String password;						//密码，MD5(CorpID+帐号密码+TimeStamp)
	private static String timeStamp = "0514094912";		//时间戳，MMDDHHMMSS（月日时分秒),如0514094912
	private static String addNum;						//扩展子号，附加于端口号后。
	private static String timer = "2010-05-14 10:30:00";//定时时间：yyyy-MM-dd HH:mm:ss 如:2010-05-14 10:30:00
	private static long longSms = 1;					//是否以长短信方式发送,0-否；1-是
	private static MobileListGroup[] mobileList;		//接收号码列表，由MobileListGroup组成，为防止超时，每次提交短信，接收号码数量建议不要超过50个。
	private static StringHolder errMsg;					//错误信息，用于返回函数调用结果的文字描述
	private static ArrayOfSmsIDListHolder smsIDList;	//短信ID列表，用于返回发送成功的短信记录ID，此短信ID可用于状态报告匹配的识别。
	private static LongHolder count ;					//调用函数的返回值：发送短信，返回短信ID(SmsID)
	private static ArrayOfSmsRecvListHolder smsRecvList; //上行短信列表，用于返回接收到的短信内容。每次最多返回20条上行短信。

    public MobsetSMSThread(SMSMessageBean bean, SMSOperationEnum operation) {
        super(bean, operation);
    }

    @Override
	protected boolean sendMessage(SMSMessageBean bean) throws Exception {
        logger.info("Start to send sms message..., parameter = " + bean.getJob());
		// 获得实例化对象
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");

		// 初始化参数
		timeStamp = formatter.format(aDate);
		errMsg = new StringHolder();
		smsIDList = new ArrayOfSmsIDListHolder();
		count = new LongHolder();
		msmResultBean msmBean = new msmResultBean();

		// 获得实例化对象
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();

		// 获取帐号信息
		corpID = Integer.valueOf(bean.getConfig().getCode());
		loginName = bean.getConfig().getUser();
		password = bean.getConfig().getPassword();

		// 将手机号码字符串分解到数组中
		List<String> mobileArray = bean.getMobiles();

		mobileList = new MobileListGroup[mobileArray.size()];
		int i = 0;
		for (String str : mobileArray) {
			MobileListGroup group = new MobileListGroup();
			group.setMobile(str);
			mobileList[i++] = group;
		}
		try {
			// MD5密码加密
			MD5 md5 = new MD5();
			password = md5.getMD5ofStr(corpID + password + timeStamp);

			// 调用发送方法进行短信下发
			mobset.sms_Send(corpID, loginName, password, timeStamp, addNum,
					timer, longSms, mobileList, bean.getJob().getContent(), count, errMsg,
					smsIDList);
			msmBean.setErrMsg(errMsg);
			msmBean.setMobileList(mobileList);
			msmBean.setSmsIDList(smsIDList);

			logger.info("短信发送返回信息：" + errMsg.value);
	        logger.info("End to send sms message...");
		} catch (Exception e) {
            logger.info("Fail to send sms message..., error message = " + e.getMessage());
			throw new PlatformUncheckException("短信发送失败 " + e.getMessage(),
					null, e);
		}
		
		return true;
	}

    @Override
    protected ReplyResultBean getReplys(SMSMessageBean bean) throws Exception {
        return null;
    }
    
    @Override
    protected List<SMSReply> receiveReplys(SMSMessageBean bean)	throws Exception {
    	logger.info("Start to replys sms message...");
    	List<SMSReply> result = null;
		// 获得实例化对象
		Date aDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		// 初始化参数
		timeStamp = formatter.format(aDate);
		errMsg = new StringHolder();
		count = new LongHolder();
		smsRecvList = new ArrayOfSmsRecvListHolder();
		// 获得实例化对象
		MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();
		// 获取帐号信息
		corpID = Integer.valueOf(bean.getConfig().getCode());
		loginName = bean.getConfig().getUser();
		password = bean.getConfig().getPassword();
		try {
			// MD5密码加密
			MD5 md5 = new MD5();
			password = md5.getMD5ofStr(corpID + password + timeStamp);
			mobset.sms_GetRecv(corpID, loginName, password, timeStamp, count, errMsg, smsRecvList);
			SmsRecvGroup[] srgArr = smsRecvList.value;
            if(srgArr != null && srgArr.length > 0) {
            	result = new ArrayList<SMSReply>();
            	for(SmsRecvGroup srg : srgArr) {
            		String content = srg.getContent();
            		String recvNum = srg.getRecvNum();
            		String mobile = srg.getMobile();
            		String recvtTimeStr = srg.getRecvTime();
            		Date recvTime = null;
            		if(StringUtils.isNotBlank(recvtTimeStr)) {
            			recvTime = DateUtils.parseDate(recvtTimeStr, new String[]{"yyyy-MM-dd HH:mm:ss"});
            		}
            		SMSReply smsReply = new SMSReply();
            		smsReply.setMobile(mobile);
            		smsReply.setContent(content);
            		smsReply.setRecvNum(recvNum);
            		smsReply.setRecvTime(recvTime);
            		result.add(smsReply);
            	}
            }
	        logger.info("End to replys sms message...");
		} catch (Exception e) {
            logger.error("Fail to give sms message..., error message = " + e.getMessage(), e);
			throw new PlatformUncheckException("接受短信失败 " + e.getMessage(),	null, e);
		}
    	return result;
    }

    @Override
    protected void confirmReply() throws Exception {

    }

    @Override
    protected List<SendResultReceipt> getReceipt(SMSMessageBean bean) throws Exception {
        
        return null;
    }
    
    
	public static void main(String[] args) {
		// 获得实例化对象
        Date aDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
        // 初始化参数
        timeStamp = formatter.format(aDate);
        errMsg = new StringHolder();
        smsIDList = new ArrayOfSmsIDListHolder();
        smsRecvList = new ArrayOfSmsRecvListHolder();
        count = new LongHolder();
        msmResultBean msmBean = new msmResultBean();

        // 获得实例化对象
        MobsetApiSoap mobset = DataObjectFactory.getMobsetApi();

        // 获取帐号信息
        corpID = Integer.valueOf(301563);
        loginName = "Admin";
        password = "501318";
        // 将手机号码字符串分解到数组中
        List<String> mobileArray = new ArrayList<String>();
        mobileArray.add("13928489648");

        mobileList = new MobileListGroup[mobileArray.size()];
        int i = 0;
        for (String str : mobileArray) {
            MobileListGroup group = new MobileListGroup();
            group.setMobile(str);
            mobileList[i++] = group;
        }
        try {
            // MD5密码加密
            MD5 md5 = new MD5();
            password = md5.getMD5ofStr(corpID + password + timeStamp);
            // 调用发送方法进行短信下发
            mobset.sms_Send(corpID, loginName, password, timeStamp, addNum,
                    timer, longSms, mobileList, "123", count, errMsg, smsIDList);
            msmBean.setErrMsg(errMsg);
            msmBean.setMobileList(mobileList);
            msmBean.setSmsIDList(smsIDList);
            System.out.println("短信发送返回消息：" + errMsg.value);
        } catch (Exception e) {
            throw new PlatformUncheckException("短信发送失败 " + e.getMessage(),
                    null, e);
        }
	}

}
