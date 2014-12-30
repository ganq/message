package com.mysoft.b2b.bizsupport.provider;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.queue.MessageTemplate;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplateCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplateService;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
public class MessageTemplateServiceTest extends BaseTestCase {

    @Autowired
    private MessageTemplateService messageTemplateService;

    @Test
    public void testAddMessage() {
        MessageTemplate mt = new MessageTemplate();
        mt.setChannel("不知道");
        mt.setCreatedBy("lvzj");
        mt.setMessageTypeCode("a3");
        mt.setMessageTemplateId("b3");
        mt.setContent("内容");
        mt.setTitle("标题");
        MessageTemplate t = messageTemplateService.insertMessageTemplate(mt);
        Assert.assertEquals(t != null, true);
    }

    @Test
    public void testGetMessage() {
        MessageTemplate mt = new MessageTemplate();
        mt.setMessageTypeCode("a3");
        MessageTemplate t = messageTemplateService.getMessageTemplate(mt);
        Assert.assertEquals(t != null, true);
    }

    @Test
    public void testGetMessage_1() {
        messageTemplateService.getMessageTemplate("2");
    }

    @Test
    public void testUpdateMessage() {
        MessageTemplate mt = new MessageTemplate();
        mt.setMessageTypeCode("a3");
        mt = messageTemplateService.getMessageTemplate(mt);
        mt.setContent("不知道_1");
        mt.setCreatedBy("lvzj_1");
        mt.setMessageTypeCode("a3");
        mt.setMessageTemplateId("2");
        mt.setTitle("标题_1");
        mt.setLastModifiedBy("qqkk");
        mt.setLastModifiedTime(new Date());
        messageTemplateService.updateMessageTemplate(mt);
    }

    @Test
    public void testSearchMessageType() {
        MessageTemplateCriteria criteria = new MessageTemplateCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        criteria.setContent("不知道_1");
        criteria.setTitle("标题_1");
        MessageTemplateCriteria _result = messageTemplateService.searchMessageTemplate(criteria);
        Assert.assertEquals(_result.getList().size() > 0, true);
    }

    @Test
    public void testDeleteMessageType() {
        MessageTemplateCriteria criteria = new MessageTemplateCriteria();
        criteria.setPageSize(20);
        criteria.setCurrentPage(1);
        MessageTemplateCriteria _result = messageTemplateService.searchMessageTemplate(criteria);
        Assert.assertEquals(true, _result.getTotalRows()> 0);
        if(_result.getTotalRows() > 0){
            List<MessageTemplate> list = _result.getList();
            if(list!=null&&list.size() > 0){
                for (MessageTemplate messageTemplate : list) {
                    messageTemplateService.deleteMessageTemplate(messageTemplate);
                }
            }
        }
    }

}
