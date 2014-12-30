/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sms;


/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月13日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public interface SMSChannelService {

    /**
     * 新建短信通道
     * @param smsChannel
     * @return
     */
    public SMSChannel insertSMSChannel(SMSChannel smsChannel);
    
    /**
     * 更新短信通道
     * @param smsChannel
     * @return
     */
    public SMSChannel updateSMSChannel(SMSChannel smsChannel);
    
    /**
     * 查询短信通道
     * @param smsChannel
     * @return
     */
    public SMSChannel getSMSChannel(SMSChannel smsChannel);
    
}
