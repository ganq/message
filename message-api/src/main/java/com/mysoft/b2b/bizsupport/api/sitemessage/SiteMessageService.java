/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sitemessage;

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

public interface SiteMessageService {

    /**
     * 生成收件箱记录ID
     * @return
     */
    public String generateSiteMessageInboxId();
    
    /**
     * 生成发件箱ID
     * @return
     */
    public String generateSiteMessageOutboxId();
    
    /**
     * 新建收件箱记录
     * @param job
     * @return
     */
    public SiteMessageInbox insertSiteMessageInbox(SiteMessageInbox inbox);
    
    /**
     * 更新收件箱记录
     * @param job
     * @return
     */
    public SiteMessageInbox updateSiteMessageInbox(SiteMessageInbox inbox);
    
    /**
     * 删除发件箱记录
     * @param job
     */
    public void deleteSiteMessageInbox(SiteMessageInbox inbox);
    
    /**
     * 删除发件箱记录
     * @param jobId
     */
    public void deleteSiteMessageInbox(String inboxId);
    
    /**
     * 查询发件箱记录
     * @param inboxId
     * @return
     */
    public SiteMessageInbox getSiteMessageInbox(String inboxId);
    
    /**
     * 分页查询发件箱记录
     * @param criteria
     * @return
     */
    public SiteMessageInboxCriteria getSiteMessageInboxList(SiteMessageInboxCriteria criteria);
  
    /**
     * 分页查询收件箱数据
     * 
     * @param criteria
     * @return
     */
    public List<SiteMessageInbox> selectSiteMessageInboxList(SiteMessageInboxCriteria criteria);
    
    /**
     * 统计收件箱数量
     * @param criteria
     * @return
     */
    public int getSiteMessageInboxCount(SiteMessageInboxCriteria criteria);
    /**
     * 新建发件箱记录
     * @param outbox
     * @return
     */
    public SiteMessageOutbox insertSiteMessageOutbox(SiteMessageOutbox outbox);
    
    /**
     * 新建发件箱记录
     * @param outbox
     * @return
     */
    public SiteMessageOutbox updateSiteMessageOutbox(SiteMessageOutbox outbox);
    
    /**
     * 更新发件箱记录
     * @param outbox
     */
    public void deleteSiteMessageOutbox(SiteMessageOutbox job);
    
    /**
     * 删除发件箱记录
     * @param outboxId
     */
    public void deleteSiteMessageOutbox(String outboxId);
    
    /**
     * 查询发件箱记录
     * @param outboxId
     * @return
     */
    public SiteMessageOutbox getSiteMessageOutbox(String outboxId);
    
    /**
     * 分页查询发件箱记录
     * @param criteria
     * @return
     */
    public SiteMessageOutboxCriteria getSiteMessageOutboxList(SiteMessageOutboxCriteria criteria);
    /**
     * 统计发件箱的数量
     * @param criteria
     * @return
     */
    public int getSiteMessageOutboxCount(SiteMessageOutboxCriteria criteria);
    /**
     * 创建站内信
     * @param inbox
     * @param outboxs
     */
    public void batchCreateSiteMessage(SiteMessageOutbox outbox, List<SiteMessageInbox> inboxs);
    
}
