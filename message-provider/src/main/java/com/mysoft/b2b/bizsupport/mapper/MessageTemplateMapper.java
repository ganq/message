/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.queue.MessageTemplate;
import com.mysoft.b2b.bizsupport.api.queue.MessageTemplateCriteria;

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

public interface MessageTemplateMapper {
    /**
     * 新建模板
     * @param messageTemplate
     */
    public int insertMessageTemplate(MessageTemplate messageTemplate);
    
    /**
     * 更新模板
     * @param messageTemplate
     */
    public int updateMessageTemplate(MessageTemplate messageTemplate);
    
    /**
     * 删除模板
     * @param messageTemplate
     */
    public int deleteMessageTemplate(MessageTemplate messageTemplate);

    /**
     * 查询模板
     * @param messageTemplate
     * @return
     */
    public MessageTemplate getMessageTemplate(String messageTemplateId);
    
    /**
     * 查询模板
     * @param messageTemplate
     * @return
     */
    public MessageTemplate getMessageTemplate_1(MessageTemplate messageTemplate);
    
    /**
     * 查询模板分页数据
     * @param criteria
     * @return
     */
    public List<MessageTemplate> searchMessageTemplate(MessageTemplateCriteria criteria);
    
    public int searchMessageTemplateSize(MessageTemplateCriteria criteria);
    
}
