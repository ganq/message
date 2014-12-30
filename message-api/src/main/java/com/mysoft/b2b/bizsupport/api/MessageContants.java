/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月18日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public abstract class MessageContants {

    /**
     * 消息队列未处理
     */
    public static final int MESSAGE_QUEUE_STATUS_DEFAULT = 1;
    /**
     * 消息队列处理中
     */
    public static final int MESSAGE_QUEUE_STATUS_DEALING = 2;
    /**
     * 消息队列处理成功
     */
    public static final int MESSAGE_QUEUE_STATUS_SUCCESS = 3;
    /**
     * 消息队列处理失败
     */
    public static final int MESSAGE_QUEUE_STATUS_FAILED  = 4;
    
    /**
     * 邮件任务未处理
     */
    public static final int EMAIL_STATUS_DEFAULT = 1;
    /**
     * 邮件任务处理中
     */
    public static final int EMAIL_STATUS_DEALING = 2;
    /**
     * 邮件任务处理成功
     */
    public static final int EMAIL_STATUS_SUCCESS = 3;
    /**
     * 邮件任务处理失败
     */
    public static final int EMAIL_STATUS_FAILED  = 4;
    
    /**
     * 短信任务未处理
     */
    public static final int SMS_STATUS_DEFAULT = 1;
    /**
     * 短信任务处理中
     */
    public static final int SMS_STATUS_DEALING = 2;
    /**
     * 短信任务处理成功
     */
    public static final int SMS_STATUS_SUCCESS = 3;
    /**
     * 短信任务处理失败
     */
    public static final int SMS_STATUS_FAILED  = 4;
    
    /**
     * 站内信已读
     */
    public static final int SITE_MESSAGE_ISREADED_YES = 1;
    
    /**
     * 站内信未读
     */
    public static final int SITE_MESSAGE_ISREADED_NO = 0;
    
    /**
     * 站内信已删
     */
    public static final int SITE_MESSAGE_DELETE_YES = 1;
    /**
     * 站内信未删
     */
    public static final int SITE_MESSAGE_DELETE_NO = 0;
    
}
