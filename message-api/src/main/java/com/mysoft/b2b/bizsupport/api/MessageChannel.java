/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api;

/**
 * chengp: 消息通道
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月18日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public enum MessageChannel {
    
    SITE_MESSAGE(1),
    EMAIL(2),
    SMS(3);
    
    private MessageChannel(int value){
        this.value = value;
    }
    
    private int value;
    
    public int getValue(){
        return value;
    }
}
