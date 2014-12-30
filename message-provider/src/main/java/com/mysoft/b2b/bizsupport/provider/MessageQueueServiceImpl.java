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
import com.mysoft.b2b.bizsupport.api.queue.MessageQueue;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.mapper.MessageQueueMapper;
import com.mysoft.b2b.commons.exception.PlatformUncheckException;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月14日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
@Service("messageQueueService")
public class MessageQueueServiceImpl implements MessageQueueService {

	private static final Logger log = Logger.getLogger(MessageQueueServiceImpl.class);
	
	@Autowired
	private MessageQueueMapper messageQueueMapper;
	@Autowired
	private IdGenerationService idGenerationService;
    @Override
    public MessageQueue insertMessageQueue(MessageQueue messageQueue) {
    	log.debug("...insertMessageQueue start messageQueue ====>"+messageQueue);
        if(null == messageQueue 
    			|| StringUtils.isEmpty(messageQueue.getTitle())
    			|| StringUtils.isEmpty(messageQueue.getContent())
    			){
    		throw new PlatformUncheckException("insertMessageQueue 参数(getTitle,getContent,)不能为NULL", null);
    		}
        long id = idGenerationService.getNextId("b2b_support.bizp_message_queue");
        long messageBatch = idGenerationService.getNextId("b2b_support.queue.messageBatch");
        String batch = messageBatch+"";
        while(true){
        	if(batch.length() < 7){
        		batch = "0"+batch;
        	}else{
        		break;
        	}
        }

        messageQueue.setMessageBatch(batch);
        messageQueue.setQueueId(id+"");
        
        if(messageQueueMapper.insertMessageQueue(messageQueue) > 0){
     	   return messageQueue;
        };
        return null;
    }

    @Override
    public MessageQueue updateMessageQueue(MessageQueue messageQueue) {
    	log.debug("...updateMessageQueue start messageQueue ====>"+messageQueue);
    	if(null == messageQueue 
    			|| StringUtils.isEmpty(messageQueue.getTitle())
    			|| StringUtils.isEmpty(messageQueue.getMessageBatch())
    			|| StringUtils.isEmpty(messageQueue.getContent())
    			|| StringUtils.isEmpty(messageQueue.getQueueId())
    					){
    		throw new PlatformUncheckException("updateMessageQueue 参数(getQueueId,getTitle,getMessageBatch,getContent)不能为NULL", null);
    	}
    	if(messageQueueMapper.updateMessageQueue(messageQueue) > 0){
     	   return messageQueue;
        };
        return null;
    }

    @Override
    public void deleteMessageQueue(String messageQueueId) {
    	log.debug("...deleteMessageTemplate start messageQueueId ====>"+messageQueueId);
    	if(StringUtils.isEmpty(messageQueueId)){
    		throw new PlatformUncheckException("deleteMessageQueue 参数(messageQueueId,)不能为NULL", null);
    	}
    	messageQueueMapper.deleteMessageQueue(messageQueueId);
    }

    @Override
    public MessageQueue getMessageQueue(String messageQueueId) {
    	log.debug("...getMessageQueue start messageQueueId ====>"+messageQueueId);
    	if(null == messageQueueId ){
    		throw new PlatformUncheckException("getMessageQueue 参数不能为NULL", null);
    	}
        return messageQueueMapper.getMessageQueue(messageQueueId);
    }

    @Override
    public MessageQueue getMessageQueue(MessageQueue messageQueue) {
    	log.debug("...getMessageQueue start messageQueue ====>"+messageQueue);
    	if(null == messageQueue ){
    		throw new PlatformUncheckException("getMessageQueue 参数不能为NULL", null);
    	}
        return  messageQueueMapper.getMessageQueue_1(messageQueue);
    }

    @Override
    public MessageQueueCriteria getMessageQueueList(MessageQueueCriteria criteria) {
    	log.debug("...getMessageQueueList start criteria ====>"+criteria);
    	
    	if(null == criteria ){
    		throw new PlatformUncheckException("getMessageQueueList 参数不能为NULL", null);
    	}
    	
    	int size = messageQueueMapper.getMessageQueueListSize(criteria);
    	
    	criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
    	criteria.setTotalRows(size);
    	
    	List<MessageQueue> lt = messageQueueMapper.getMessageQueueList(criteria);
    	
    	criteria.setList(lt);
    	
        return criteria;
    }
    
    @Override
    public int getMessageQueueListCount(MessageQueueCriteria criteria) {
		if (null == criteria) {
			throw new PlatformUncheckException("getMessageQueueList 参数不能为NULL", null);
		}
    	return messageQueueMapper.getMessageQueueListSize(criteria);
    }

    @Override
    public List<MessageQueue> getSchedulerMessageQueueList(MessageQueueCriteria criteria) {
        return messageQueueMapper.getSchedulerMessageQueueList(criteria);
    }

}
