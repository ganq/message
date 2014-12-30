package com.mysoft.b2b.bizsupport.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * chengp: 消息服务接口
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月18日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
public interface MessageCenterService {

    /**
     * 按照类型模板发送消息(暂时不支持附件)
     * @param sender
     * @param senderId
     * @param receivers
     * @param title
     * @param typeCode
     * @param parameters
     * @param attList
     * @return
     */
    public boolean sendMessageByTemplateId(String sender, String senderId, List<MessageReceiver> receivers, String templateId,
            Map<String, String> parameters, List<MessageAttatchment> attList);

    /**
     * 发送消息(暂时不支持附件)
     * @param sender
     * @param senderId
     * @param receivers
     * @param title
     * @param typeCode
     * @param content
     * @param parameters
     * @param attList
     * @return
     */
    public boolean sendSimpleMessage(String sender, String senderId, List<MessageReceiver> receivers, String title,String typeCode,
            String content, HashMap<String, String> parameters, List<MessageAttatchment> attList,String channel);
    

}
