package com.mysoft.b2b.bizsupport.provider;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.queue.MessageQueue;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;


@RunWith(SpringJUnit4ClassRunner.class)
public class MessageQueueServiceTest extends BaseTestCase{

	@Autowired
	private MessageQueueService messageQueueService;
	
	@Test
	public void testAddMessageQueue() {
		MessageQueue mt = new MessageQueue();
		
		mt.setChannel("不知道");
		mt.setAttachments("setAttachments");
		mt.setContent("xxxxxxxxxxxx");
		mt.setMessageBatch("xxxxxxxxxxxxxxxxxx");
		mt.setMessageTypeCode("a1");
		mt.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
		mt.setSenderId("a1");
		mt.setSender("xxxxxxxxxxxxxx");
		
		mt.setStatus(1);
		mt.setMessageTypeCode("a3");
		mt.setTitle("标题111xxxxxxxxxxxxxxxx");
		
		MessageQueue t = messageQueueService.insertMessageQueue(mt);
		
		Assert.assertEquals(true, t != null);
	}
	
	@Test
	public void testGetMessage() {
		MessageQueue mt = new MessageQueue();
		mt.setQueueId("2");
		messageQueueService.getMessageQueue(mt);
	}
	
	@Test
	public void testGetMessage_1() {
	    messageQueueService.getMessageQueue("2");
	}
	
	@Test
	public void testUpdateMessage() {
	    MessageQueueCriteria criteria = new MessageQueueCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        criteria.setSender("xxxxxxxxxxxxxx");
        MessageQueueCriteria _result =  messageQueueService.getMessageQueueList(criteria);
        
		MessageQueue mt = _result.getList().get(0);
		mt.setContent("不知道xxxxxxxxxxxx");
		mt.setAttachments("xxxxxxxxxx");
		mt.setContent("xxxxxxxxxxxxxxxx");
		mt.setMessageBatch("xxxxxxxx");
		mt.setMessageTypeCode("xxxxxxxxxxxxxxxxxx");
		mt.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
		mt.setSenderId("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
		mt.setSender("xxxxxxxxxxxxxx");
		mt.setStatus(1);
		mt.setMessageTypeCode("a3");
		mt.setTitle("标题xxxxxxxxxxxxxxxx");
		messageQueueService.updateMessageQueue(mt);
	}
	
	@Test
	public void testSearchMessage() {
		MessageQueueCriteria criteria = new MessageQueueCriteria();
		criteria.setPageSize(20);
		criteria.setCurrentPage(1);
		criteria.setTitle("xxxxxxxxxxxxxxxx");
		criteria.setContent("xxxxxxxxxxxx");
		criteria.setMessageBatch("xxxxxxxx");
		criteria.setMessageTypeCode("a3");
		criteria.setDealtTime(MessageUtil.getDateBefore(0));
		criteria.setReceiver("chengp");
		criteria.setSender("xxxxxxxxxxxxxx");
		criteria.setSenderId("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
		MessageQueueCriteria _result =	messageQueueService.getMessageQueueList(criteria);
		Assert.assertEquals(true, _result.getTotalRows()> 0);
	}

    @Test
    public void testGetSchedulerMessageQueueList(){
        MessageQueueCriteria criteria = new MessageQueueCriteria();
        criteria.setPageSize(10);
        criteria.setCurrentPage(1);
        criteria.setTryTimes(3);
        criteria.setDealtTime(MessageUtil.getDateBefore(3));
        List<MessageQueue> list = messageQueueService.getSchedulerMessageQueueList(criteria);
        Assert.assertEquals(true, list.size()> 0);
    }
    
	@Test
	public void testDeleteMessageType() {
		MessageQueueCriteria criteria = new MessageQueueCriteria();
		criteria.setPageSize(20);
		criteria.setCurrentPage(1);
		criteria.setSender("xxxxxxxxxxxxxx");
		
		MessageQueueCriteria _result =	messageQueueService.getMessageQueueList(criteria);
		Assert.assertEquals(true, _result.getTotalRows()> 0);
		if(_result.getTotalRows() > 0){
		    List<MessageQueue> list = _result.getList();
		    if(list!=null&&list.size() > 0){
		        for (MessageQueue messageQueue : list) {
		            messageQueueService.deleteMessageQueue(messageQueue.getQueueId());
                }
		    }
		}
		_result =	messageQueueService.getMessageQueueList(criteria);
		Assert.assertEquals(0, _result.getTotalRows());
	}
	
}
