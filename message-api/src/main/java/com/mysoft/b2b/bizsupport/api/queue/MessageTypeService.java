/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.queue;

import java.util.List;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月13日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public interface MessageTypeService {
    
    /**
     * 新建模板
     * @param MessageType
     * @return
     */
    public MessageType insertMessageType(MessageType MessageType);
    
    /**
     * 更新模板
     * @param MessageType
     * @return
     */
    public MessageType updateMessageType(MessageType MessageType);
    
    /**
     * 删除模板
     * @param MessageType
     */
    public void deleteMessageType(MessageType MessageType);

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
    public MessageType getMessageType(MessageType MessageType);
    
    /**
     * 查询模板分页数据
     * @param criteria
     * @return
     */
    public MessageTypeCriteria searchMessageType(MessageTypeCriteria criteria);
    
    /**
     * 获取消息类型集合
     * 
     * @param typeCodes
     * @return
     */
    List<MessageType> getMessageTypeList(MessageTypeCriteria criteria);
    
    
}
