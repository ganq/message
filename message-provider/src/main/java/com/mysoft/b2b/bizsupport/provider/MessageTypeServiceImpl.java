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
import com.mysoft.b2b.bizsupport.api.queue.MessageType;
import com.mysoft.b2b.bizsupport.api.queue.MessageTypeCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageTypeService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.mapper.MessageTypeMapper;
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
@Service("messageTypeService")
public class MessageTypeServiceImpl implements MessageTypeService {

	private static final Logger log = Logger.getLogger(MessageTypeServiceImpl.class);
	@Autowired
	private IdGenerationService idGenerationService;
	@Autowired
	private MessageTypeMapper messageTypeMapper;
	
    @Override
    public MessageType insertMessageType(MessageType messageType) {
       log.debug("...insertMessageType start MessageType ====>"+messageType);
       if(null == messageType 
   			|| StringUtils.isEmpty(messageType.getMessageTypeCode())
   			|| StringUtils.isEmpty(messageType.getTitle())
   			|| StringUtils.isEmpty(messageType.getCreatedBy())
   			){
   		throw new PlatformUncheckException("insertMessageType 参数(getCreatedBy,getTitle,getMessageTypeCode)不能为NULL", null);
   		}
       long id = idGenerationService.getNextId("b2b_support.bizp_message_type");
       messageType.setMessageTypeId(id+"");
       if(messageTypeMapper.insertMessageType(messageType) > 0){
    	   return messageType;
       };
       return null;
    }

    @Override
    public MessageType updateMessageType(MessageType messageType) {
    	log.debug("...updateMessageType start MessageType ====>"+messageType);
    	if(null == messageType 
    			|| StringUtils.isEmpty(messageType.getMessageTypeCode())
    			|| StringUtils.isEmpty(messageType.getMessageTypeId())){
    		throw new PlatformUncheckException("updateMessageType 参数(getMessageTypeCode,getMessageTypeId)不能为NULL", null);
    	}
    	if(messageTypeMapper.updateMessageType(messageType) > 0){
     	   return messageType;
        };
        return null;
    }

    @Override
    public void deleteMessageType(MessageType messageType) {
    	log.debug("...deleteMessageType start MessageType ====>"+messageType);
    	if(null == messageType 
    			|| StringUtils.isEmpty(messageType.getMessageTypeCode())
    			|| StringUtils.isEmpty(messageType.getMessageTypeId())){
    		throw new PlatformUncheckException("deleteMessageType 参数(getMessageTypeCode,getMessageTypeId)不能为NULL", null);
    	}
    	messageTypeMapper.deleteMessageType(messageType);
    }

    @Override
    public MessageType getMessageType(String messageTypeId) {
    	log.debug("...getMessageType start messageTypeId ====>"+messageTypeId);
    	if(null == messageTypeId ){
    		throw new PlatformUncheckException("getMessageType 参数不能为NULL", null);
    	}
        return messageTypeMapper.getMessageType(messageTypeId);
    }

    @Override
    public MessageType getMessageType(MessageType messageType) {
    	log.debug("...getMessageType start messageType ====>"+messageType);
    	if(null == messageType ){
    		throw new PlatformUncheckException("getMessageType 参数不能为NULL", null);
    	}
        return  messageTypeMapper.getMessageType_1(messageType);
    }

    @Override
    public MessageTypeCriteria searchMessageType(MessageTypeCriteria criteria) {

    	log.debug("...searchMessageType start criteria ====>"+criteria);
    	
    	if(null == criteria ){
    		throw new PlatformUncheckException("searchMessageType 参数不能为NULL", null);
    	}
    	
    	int size = messageTypeMapper.searchMessageTypeSize(criteria);
    	
    	criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
    	criteria.setTotalRows(size);
    	
    	List<MessageType> lt = messageTypeMapper.searchMessageType(criteria);
    	
    	criteria.setList(lt);
    	
        return criteria;
    }
    
    @Override
    public List<MessageType> getMessageTypeList(MessageTypeCriteria criteria) {
    	return messageTypeMapper.getMessageTypeList(criteria);
    }

}
