package com.mysoft.b2b.bizsupport.provider;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.queue.MessageType;
import com.mysoft.b2b.bizsupport.api.queue.MessageTypeCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageTypeService;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
public class MessageTypeServiceTest extends BaseTestCase {

    @Autowired
    private MessageTypeService messageTypeService;

    @Test
    public void testAddMessageType() {
        MessageType mt = new MessageType();
        mt.setChannel("不知道");
        mt.setCreatedBy("lvzj");
        mt.setMessageTypeCode("a5");
        mt.setMessageTypeId("b5");
        mt.setRemark("说明");
        mt.setTitle("标题");
        MessageType t = messageTypeService.insertMessageType(mt);
        Assert.assertEquals(t != null, true);
    }

    @Test
    public void testGetMessageType() {
        MessageType mt = new MessageType();
        mt.setMessageTypeCode("a5");
        mt = messageTypeService.getMessageType(mt);
        Assert.assertEquals(mt != null, true);
    }

    @Test
    public void testSearchMessageType() {
        MessageTypeCriteria criteria = new MessageTypeCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        criteria.setChannel("不知道");
        criteria.setMessageTypeCode("a5");
        criteria.setTitle("标题");
        criteria = messageTypeService.searchMessageType(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testGetMessageType_1() {
        MessageTypeCriteria criteria = new MessageTypeCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        criteria.setMessageTypeCode("a5");
        criteria = messageTypeService.searchMessageType(criteria);
        
        MessageType mt = messageTypeService.getMessageType(criteria.getList().get(0));
        Assert.assertEquals(mt != null, true);
    }

    @Test
    public void testUpdateMessageType() {
        MessageTypeCriteria criteria = new MessageTypeCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        criteria.setMessageTypeCode("a5");
        criteria = messageTypeService.searchMessageType(criteria);
        
        MessageType mt = criteria.getList().get(0);
        mt.setChannel("不知道_1");
        mt.setCreatedBy("lvzj_1");
        mt.setMessageTypeCode("a3");
        mt.setMessageTypeId("b3");
        mt.setRemark("说明_1");
        mt.setTitle("标题_1");
        mt.setLastModifiedBy("qqkk");
        mt.setLastModifiedTime(new Date());
        messageTypeService.updateMessageType(mt);
        
    }

    @Test
    public void testDeleteMessageType() {
        MessageTypeCriteria criteria = new MessageTypeCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        criteria.setMessageTypeCode("a5");
        criteria = messageTypeService.searchMessageType(criteria);
        
        messageTypeService.deleteMessageType(criteria.getList().get(0));
        
        criteria = messageTypeService.searchMessageType(criteria);
        
        Assert.assertTrue(criteria.getList() == null || criteria.getList().size() == 0);
    }

}
