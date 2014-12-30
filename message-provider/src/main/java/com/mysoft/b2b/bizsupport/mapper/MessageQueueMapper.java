/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.queue.MessageQueue;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueCriteria;

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

public interface MessageQueueMapper {

    /**
     * 新建消息队列
     * @param messageQueue
     * @return
     */
    public int insertMessageQueue(MessageQueue messageQueue);
    
    /**
     * 更新消息队列
     * @param messageQueue
     * @return
     */
    public int updateMessageQueue(MessageQueue messageQueue);
    
    /**
     * 删除消息队列
     * @param messageQueueId
     */
    public int deleteMessageQueue(String messageQueueId);
    
    /**
     * 查询消息队列
     * @param messageQueueId
     * @return
     */
    public MessageQueue getMessageQueue(String messageQueueId);
    
    /**
     * 查询消息队列
     * @param messageQueue
     * @return
     */
    public MessageQueue getMessageQueue_1(MessageQueue messageQueue);
    
    /**
     * 分页查询消息队列
     * @param criteria
     * @return
     */
    public List<MessageQueue> getMessageQueueList(MessageQueueCriteria criteria);
    
    /**
     * 获取总数
     * @param criteria
     * @return
     */
    public int getMessageQueueListSize(MessageQueueCriteria criteria);

    /**
     * 获取调度任务数据
     * @param criteria
     * @return
     */
    public List<MessageQueue> getSchedulerMessageQueueList(MessageQueueCriteria criteria);
    
}
