/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.sms.mobset;

import java.util.List;

import com.mysoft.b2b.bizsupport.scheduler.sms.util.ChannelService;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.SMSMessageBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.SMSOperationEnum;
import com.mysoft.b2b.bizsupport.scheduler.util.ThreadPoolManager;

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

public class MobsetChannelServiceImpl implements ChannelService {

    @Override
    public void sendSMS(SMSMessageBean bean) throws Exception {
        ThreadPoolManager.addTask(new MobsetSMSThread(bean, SMSOperationEnum.SMS_SEND));
    }

    @Override
    public void dealReceipt() throws Exception {
        
    }

    @Override
    public void dealReply(SMSMessageBean bean) throws Exception {
    	ThreadPoolManager.addTask(new MobsetSMSThread(bean, SMSOperationEnum.SMS_REPLY));
    }

    @Override
    public void confimReplySMS() throws Exception {
        

    }

    @Override
    public void sendList(List<SMSMessageBean> list) throws Exception {
        

    }

    @Override
    public void updatePwd(SMSMessageBean bean, String pwd) throws Exception {
        

    }

    @Override
    public void reSend(SMSMessageBean bean) throws Exception {
        
        
    }

    @Override
    public String getCost(SMSMessageBean bean) {
        
        return null;
    }

}
