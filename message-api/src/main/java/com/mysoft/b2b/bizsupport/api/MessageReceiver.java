/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api;

import java.io.Serializable;
import java.util.Map;

/**
 * chengp: 消息接收者
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月18日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

@SuppressWarnings("serial")
public class MessageReceiver implements Serializable {

    private String receiverId;

    private String receiver;

    private Map<Integer, String> addrMap;

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Map<Integer, String> getAddrMap() {
        return addrMap;
    }

    public void setAddrMap(Map<Integer, String> addrMap) {
        this.addrMap = addrMap;
    }

    public MessageReceiver(){
        
    }
    
    public MessageReceiver(String receiverId, String receiver){
        this(receiverId, receiver, null);
    }
    
    public MessageReceiver(String receiverId, String receiver, Map<Integer, String> addrMap){
        this.receiverId = receiverId;
        this.receiver = receiver;
        this.addrMap = addrMap;
    }
    
    @Override
    public String toString() {
        return "receiverId="+receiverId+",receiver="+receiver+",addrMap="+addrMap;
    }
}
