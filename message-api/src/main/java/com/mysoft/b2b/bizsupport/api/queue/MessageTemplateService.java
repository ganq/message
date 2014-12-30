/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.queue;

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

public interface MessageTemplateService {
    
    /**
     * 新建模板
     * @param messageTemplate
     * @return
     */
    public MessageTemplate insertMessageTemplate(MessageTemplate messageTemplate);
    
    /**
     * 更新模板
     * @param messageTemplate
     * @return
     */
    public MessageTemplate updateMessageTemplate(MessageTemplate messageTemplate);
    
    /**
     * 删除模板
     * @param messageTemplate
     */
    public void deleteMessageTemplate(MessageTemplate messageTemplate);

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
    public MessageTemplate getMessageTemplate(MessageTemplate messageTemplate);
    
    /**
     * 查询模板分页数据
     * @param criteria
     * @return
     */
    public MessageTemplateCriteria searchMessageTemplate(MessageTemplateCriteria criteria);
    
}
