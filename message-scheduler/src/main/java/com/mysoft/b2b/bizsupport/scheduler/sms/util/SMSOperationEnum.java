/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.sms.util;

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

public enum SMSOperationEnum {
    /**
     * 发送短信操作
     */
    SMS_SEND(1),
    /**
     * 获取短信回复操作
     */
    SMS_REPLY(2),
    /**
     * 获取短信回执操作
     */
    SMS_RECEIPT(3),
    /**
     * 获取短信通道帐号操作
     */
    SMS_ACCOUNT(4);
    
    private int value;

    private SMSOperationEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
    
}
