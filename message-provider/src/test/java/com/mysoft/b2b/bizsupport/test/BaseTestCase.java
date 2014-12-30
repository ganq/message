package com.mysoft.b2b.bizsupport.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;

import com.mysoft.b2b.bizsupport.api.MessageChannel;
import com.mysoft.b2b.bizsupport.api.MessageReceiver;

@ContextConfiguration(locations = { "classpath*:/META-INF/spring/*.xml" })
public class BaseTestCase {

    protected Logger logger = Logger.getLogger(this.getClass());
    
    public List<MessageReceiver> getReceivers(){
        List<MessageReceiver> receivers = new ArrayList<MessageReceiver>();
        MessageReceiver receiver = new MessageReceiver();
        receiver.setReceiver("1");
        receiver.setReceiverId("123");
        Map<Integer, String> addrMap = new HashMap<Integer, String>();
        addrMap.put(MessageChannel.EMAIL.getValue(), "chengp@mysoft.com.cn");
        addrMap.put(MessageChannel.SMS.getValue(), "13928489648");
        addrMap.put(MessageChannel.SITE_MESSAGE.getValue(), "2");
        receiver.setAddrMap(addrMap);
        receivers.add(receiver);
        return receivers;
    }
}
