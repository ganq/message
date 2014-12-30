package com.mysoft.b2b.bizsupport.provider;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysoft.b2b.bizsupport.api.MessageAttatchment;
import com.mysoft.b2b.bizsupport.api.MessageCenterService;
import com.mysoft.b2b.bizsupport.api.MessageContants;
import com.mysoft.b2b.bizsupport.api.MessageReceiver;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueue;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueService;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplate;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplateService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;

/**
 * 消息服务实现类
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月18日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
@Service("messageCenterService")
public class MessageCenterServiceImpl implements MessageCenterService {

    private static final Logger logger = Logger.getLogger(MessageCenterServiceImpl.class);
    
    @Autowired
    private MessageQueueService messageQueueService;

    @Autowired
    private MessageTemplateService messageTemplateService;

    @Override
    public boolean sendMessageByTemplateId(String sender, String senderId, List<MessageReceiver> receivers, String templateId,
            Map<String, String> parameters, List<MessageAttatchment> attList) {
        logger.info("---sendMessageByType---, parameter: sender" + sender+" senderId="+senderId + " receivers="+receivers+" templateId="+templateId);
        MessageTemplate template = new MessageTemplate();
        template = messageTemplateService.getMessageTemplate(templateId);
        String content = MessageUtil.replaceVariable(template.getContent(), parameters);
        String title = MessageUtil.replaceVariable(template.getTitle(), parameters);
        this.createAndSaveMessageQueue(sender, senderId, receivers, title, template.getMessageTypeCode(), content, parameters, attList,template.getChannel());
        return true;
    }
    
    
    @Override
    public boolean sendSimpleMessage(String sender, String senderId, List<MessageReceiver> receivers, String title, String typeCode,
            String content, HashMap<String, String> parameters, List<MessageAttatchment> attList,String channel) {
        logger.info("---sendSimpleMessage---, parameter: sender" + sender+" senderId="+senderId + " receivers="+receivers+" title="+title+" typeCode="+typeCode);
        if(parameters != null && !parameters.isEmpty()){
            content = MessageUtil.replaceVariable(content, parameters);
            title = MessageUtil.replaceVariable(title, parameters);
        }
        this.createAndSaveMessageQueue(sender, senderId, receivers, title, typeCode, content, parameters, attList, channel);
        return true;
    }
    
    
    private MessageQueue createAndSaveMessageQueue(String sender, String senderId, List<MessageReceiver> receivers, String title,
            String typeCode, String content, Map<String, String> parameters, List<MessageAttatchment> attList, String channel) {
        
        MessageQueue queue = new MessageQueue();
        queue.setCreatedTime(new Date());
        queue.setSender(sender);
        queue.setSenderId(senderId);
        queue.setReceiver(MessageUtil.getJsonByObject(receivers));
        queue.setTitle(title);
        queue.setMessageTypeCode(typeCode);
        queue.setContent(content);
        queue.setAttachments(MessageUtil.getJsonByObject(attList));
        queue.setStatus(MessageContants.MESSAGE_QUEUE_STATUS_DEFAULT);
        queue.setChannel(channel);
        messageQueueService.insertMessageQueue(queue);
        return queue;
    }

}
