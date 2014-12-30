/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInboxCriteria;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutboxCriteria;

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

public interface SiteMessageMapper {
    /**
     * 新建发件箱记录
     * @param job
     * @return
     */
    public void insertSiteMessageInbox(SiteMessageInbox inbox);
    
    /**
     * 更新发件箱记录
     * @param job
     * @return
     */
    public void updateSiteMessageInbox(SiteMessageInbox inbox);
    
    /**
     * 删除发件箱记录
     * @param jobId
     */
    public void deleteSiteMessageInbox(String inboxId);
    
    /**
     * 查询发件箱记录
     * @param job
     * @return
     */
    public SiteMessageInbox getSiteMessageInbox(String inboxId);
    
    /**
     * 分页查询发件箱
     * @param criteria
     * @return
     */
    public List<SiteMessageInbox> getSiteMessageInboxList(SiteMessageInboxCriteria criteria);
    
    /**
     * 分页查询发件箱
     * @param criteria
     * @return
     */
    public int getSiteMessageInboxTotal(SiteMessageInboxCriteria criteria);
    
    
    /**
     * 新建发件箱记录
     * @param outbox
     * @return
     */
    public void insertSiteMessageOutbox(SiteMessageOutbox outbox);
    
    /**
     * 新建收件箱记录
     * @param outbox
     * @return
     */
    public void updateSiteMessageOutbox(SiteMessageOutbox outbox);
    
    /**
     * 删除收件箱记录
     * @param outboxId
     */
    public void deleteSiteMessageOutbox(String outboxId);
    
    /**
     * 查询收件箱记录
     * @param job
     * @return
     */
    public SiteMessageOutbox getSiteMessageOutbox(String outboxId);
    
    /**
     * 分页查询收件箱记录
     * @param criteria
     * @return
     */
    public List<SiteMessageOutbox> getSiteMessageOutboxList(SiteMessageOutboxCriteria criteria);
    
    /**
     * 获取记录总数
     * @param criteria
     * @return
     */
    public int getSiteMessageOutboxTotal(SiteMessageOutboxCriteria criteria);
    
    /**
     * 批量创建收件箱记录
     * @param outboxs
     */
    public void batchCreateSiteMessageInbox(List<SiteMessageInbox> inboxs);
    
}
