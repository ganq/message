/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.provider;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysoft.b2b.bizsupport.api.IdGenerationService;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplate;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplateCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplateService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.mapper.MessageTemplateMapper;
import com.mysoft.b2b.commons.exception.PlatformUncheckException;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月14日     Created
 * lvzj    1.0           2014年8月18日     update
 * </pre>
 * @since b2b 2.0.0
 */
@Service("messageTemplateService")
public class MessageTemplateServiceImpl implements MessageTemplateService {

	private static final Logger log = Logger.getLogger(MessageTemplateServiceImpl.class);
	
	@Autowired
	private MessageTemplateMapper messageTemplateMapper;
	@Autowired
	private IdGenerationService idGenerationService;
    @Override
    public MessageTemplate insertMessageTemplate(MessageTemplate messageTemplate) {
    	 log.debug("...insertMessageTemplate start messageTemplate ====>"+messageTemplate);
         if(null == messageTemplate 
     			|| StringUtils.isEmpty(messageTemplate.getMessageTypeCode())
     			|| StringUtils.isEmpty(messageTemplate.getTitle())
     			|| StringUtils.isEmpty(messageTemplate.getCreatedBy())
     			|| StringUtils.isEmpty(messageTemplate.getContent())
     			){
     		throw new PlatformUncheckException("insertMessageTemplate 参数(getCreatedBy,getTitle,getMessageTypeCode,getMessageTypeId)不能为NULL", null);
     		}
         long id = idGenerationService.getNextId("b2b_support.bizp_message_template");
         messageTemplate.setMessageTemplateId(id+"");
         
         if(messageTemplateMapper.insertMessageTemplate(messageTemplate) > 0){
      	   return messageTemplate;
         };
         return null;
    }

    @Override
    public MessageTemplate updateMessageTemplate(MessageTemplate messageTemplate) {
    	log.debug("...updateMessageTemplate start messageTemplate ====>"+messageTemplate);
    	if(null == messageTemplate 
    			|| StringUtils.isEmpty(messageTemplate.getMessageTypeCode())
    			|| StringUtils.isEmpty(messageTemplate.getMessageTemplateId())
    			|| StringUtils.isEmpty(messageTemplate.getContent())){
    		throw new PlatformUncheckException("updateMessageTemplate 参数(getContent,getMessageTypeCode,getMessageTemplateId)不能为NULL", null);
    	}
    	if(messageTemplateMapper.updateMessageTemplate(messageTemplate) > 0){
     	   return messageTemplate;
        };
        return null;
    }

    @Override
    public void deleteMessageTemplate(MessageTemplate messageTemplate) {
    	log.debug("...deleteMessageTemplate start messageTemplate ====>"+messageTemplate);
    	if(null == messageTemplate 
    			|| StringUtils.isEmpty(messageTemplate.getMessageTypeCode())
    			|| StringUtils.isEmpty(messageTemplate.getMessageTemplateId())){
    		throw new PlatformUncheckException("deleteMessageTemplate 参数(getMessageTypeCode,getMessageTemplateId)不能为NULL", null);
    	}
    	messageTemplateMapper.deleteMessageTemplate(messageTemplate);
    }

    @Override
    public MessageTemplate getMessageTemplate(String messageTemplateId) {
    	log.debug("...getMessageTemplate start messageTemplateId ====>"+messageTemplateId);
    	if(null == messageTemplateId ){
    		throw new PlatformUncheckException("getMessageTemplate 参数不能为NULL", null);
    	}
        return messageTemplateMapper.getMessageTemplate(messageTemplateId);
    }

    @Override
    public MessageTemplate getMessageTemplate(MessageTemplate messageTemplate) {
    	log.debug("...getMessageTemplate start messageTemplate ====>"+messageTemplate);
    	if(null == messageTemplate ){
    		throw new PlatformUncheckException("getMessageTemplate 参数不能为NULL", null);
    	}
        return  messageTemplateMapper.getMessageTemplate_1(messageTemplate);
    }

    @Override
    public MessageTemplateCriteria searchMessageTemplate(MessageTemplateCriteria criteria) {
    	log.debug("...searchMessageTemplate start criteria ====>"+criteria);
    	
    	if(null == criteria ){
    		throw new PlatformUncheckException("searchMessageTemplate 参数不能为NULL", null);
    	}
    	
    	int size = messageTemplateMapper.searchMessageTemplateSize(criteria);
    	
    	criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
    	criteria.setTotalRows(size);
    	
    	List<MessageTemplate> lt = messageTemplateMapper.searchMessageTemplate(criteria);
    	
    	criteria.setList(lt);
    	
        return criteria;
    }

}
