/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.queue.MessageType;
import com.mysoft.b2b.bizsupport.api.queue.MessageTypeCriteria;

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

public interface MessageTypeMapper {
    /**
     * 新建模板
     * @param MessageType
     * @return
     */
    public int insertMessageType(MessageType MessageType);
    
    /**
     * 更新模板
     * @param MessageType
     * @return
     */
    public int updateMessageType(MessageType MessageType);
    
    /**
     * 删除模板
     * @param MessageType
     */
    public int deleteMessageType(MessageType MessageType);

    /**
     * 查询模板
     * @param MessageType
     * @return
     */
    public MessageType getMessageType(String MessageTypeId);
    
    /**
     * 查询模板
     * @param MessageType
     * @return
     */
    public MessageType getMessageType_1(MessageType MessageType);
    
    /**
     * 查询模板分页数据
     * @param criteria
     * @return
     */
    public List<MessageType> searchMessageType(MessageTypeCriteria criteria);
    /**
     * 查询模板分页数据
     * @param criteria
     * @return
     */
    public int searchMessageTypeSize(MessageTypeCriteria criteria);
    
    /**
     * 获取消息类型集合
     * 
     * @param typeCodes
     * @return
     */
    List<MessageType> getMessageTypeList(MessageTypeCriteria criteria);
    
}
