package com.mysoft.b2b.bizsupport.provider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.MessageCenterService;
import com.mysoft.b2b.bizsupport.api.MessageChannel;
import com.mysoft.b2b.bizsupport.api.MessageReceiver;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageCenterServiceTest extends BaseTestCase {
	
	private static final Logger log = Logger.getLogger(MessageCenterServiceTest.class);

	@Autowired
	private MessageCenterService messageCenterService;
	
    @Test
    public void testSendMsg() {
    	String companyId = "K000002";
    	String supplierId = "G00014";
		MessageReceiver msgReceiver = new MessageReceiver();
		Map<Integer, String> addrMap = new HashMap<Integer, String>();
		addrMap.put(MessageChannel.SITE_MESSAGE.getValue(), supplierId);
		msgReceiver.setReceiver(supplierId);
		msgReceiver.setReceiverId(supplierId);
		msgReceiver.setAddrMap(addrMap);
		List<MessageReceiver> receivers = Arrays.asList(new MessageReceiver[]{msgReceiver});
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("id", "153");
		parameters.put("developerUrl", "http://K000002.com");
		parameters.put("title", "TEST");
    	boolean isSucc = messageCenterService.sendMessageByTemplateId(companyId, companyId, receivers, "4", parameters, null);
    	log.info("isSucc-------------->" + isSucc);
    }
}
