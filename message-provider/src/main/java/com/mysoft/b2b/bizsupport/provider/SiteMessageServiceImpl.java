/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysoft.b2b.bizsupport.api.IdGenerationService;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInboxCriteria;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutboxCriteria;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.mapper.SiteMessageMapper;

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

@Service(value = "siteMessageService")
public class SiteMessageServiceImpl implements SiteMessageService {

    private Logger logger = Logger.getLogger(SiteMessageService.class);

    @Autowired
    private SiteMessageMapper siteMessageMapper;

    @Autowired
    private IdGenerationService idGenerationService;

    @Override
    public String generateSiteMessageOutboxId() {
        return idGenerationService.getNextId("b2b_support.bizp_sitemessage_outbox") + "";
    }

    @Override
    public String generateSiteMessageInboxId() {
        return idGenerationService.getNextId("b2b_support.bizp_sitemessage_inbox") + "";
    }
    
    @Override
    @Transactional
    public SiteMessageInbox insertSiteMessageInbox(SiteMessageInbox inbox) {
        if (inbox == null) {
            logger.info("插入数据失败，对象为空");
            return null;
        }
        if (StringUtils.isEmpty(inbox.getInboxId())) {
            inbox.setInboxId(generateSiteMessageInboxId());
        }
        siteMessageMapper.insertSiteMessageInbox(inbox);
        return inbox;
    }

    @Override
    @Transactional
    public SiteMessageInbox updateSiteMessageInbox(SiteMessageInbox inbox) {
        if (inbox == null) {
            logger.info("更新数据失败，对象为空");
            return null;
        }
        siteMessageMapper.updateSiteMessageInbox(inbox);
        return inbox;
    }

    @Override
    @Transactional
    public void deleteSiteMessageInbox(SiteMessageInbox inbox) {
        if (inbox != null && StringUtils.isNotEmpty(inbox.getInboxId())) {
            siteMessageMapper.deleteSiteMessageInbox(inbox.getInboxId());
        }
    }

    @Override
    @Transactional
    public void deleteSiteMessageInbox(String inboxId) {
        if (StringUtils.isNotEmpty(inboxId)) {
            siteMessageMapper.deleteSiteMessageInbox(inboxId);
        }
    }

    @Override
    public SiteMessageInbox getSiteMessageInbox(String inboxId) {
        if (StringUtils.isEmpty(inboxId))
            return null;
        return siteMessageMapper.getSiteMessageInbox(inboxId);
    }

    @Override
    public SiteMessageInboxCriteria getSiteMessageInboxList(SiteMessageInboxCriteria criteria) {
        if (criteria == null)
            return null;
        criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
        List<SiteMessageInbox> data = siteMessageMapper.getSiteMessageInboxList(criteria);
        int total = siteMessageMapper.getSiteMessageInboxTotal(criteria);
        criteria.setList(data);
        criteria.setTotalRows(total);
        return criteria;
    }

    /******************************发件箱*********************************************/
    @Override
    @Transactional
    public SiteMessageOutbox insertSiteMessageOutbox(SiteMessageOutbox outbox) {
        if (outbox == null) {
            logger.info("插入数据失败，对象为空");
            return null;
        }
        if (StringUtils.isEmpty(outbox.getOutboxId())) {
            outbox.setOutboxId(generateSiteMessageOutboxId());
        }
        siteMessageMapper.insertSiteMessageOutbox(outbox);
        return outbox;
    }

    @Override
    @Transactional
    public SiteMessageOutbox updateSiteMessageOutbox(SiteMessageOutbox outbox) {
        if (outbox == null) {
            logger.info("更新数据失败，对象为空");
            return null;
        }
        siteMessageMapper.updateSiteMessageOutbox(outbox);
        return outbox;
    }

    @Override
    @Transactional
    public void deleteSiteMessageOutbox(SiteMessageOutbox outbox) {
        if (outbox != null && StringUtils.isNotEmpty(outbox.getOutboxId())) {
            siteMessageMapper.deleteSiteMessageOutbox(outbox.getOutboxId());
        }
    }

    @Override
    @Transactional
    public void deleteSiteMessageOutbox(String outboxId) {
        if (StringUtils.isNotEmpty(outboxId)) {
            siteMessageMapper.deleteSiteMessageOutbox(outboxId);
        }
    }

    @Override
    public SiteMessageOutbox getSiteMessageOutbox(String outboxId) {
        if (StringUtils.isEmpty(outboxId))
            return null;
        return siteMessageMapper.getSiteMessageOutbox(outboxId);
    }

    @Override
    public SiteMessageOutboxCriteria getSiteMessageOutboxList(SiteMessageOutboxCriteria criteria) {
        logger.debug("...getSiteMessageOutboxList start ====> " + criteria);
        if (criteria == null)
            return null;
        criteria.setOffset(MessageUtil.getPageOffset(criteria.getPageSize(), criteria.getCurrentPage()));
        List<SiteMessageOutbox> data = siteMessageMapper.getSiteMessageOutboxList(criteria);
        int total = siteMessageMapper.getSiteMessageOutboxTotal(criteria);
        criteria.setList(data);
        criteria.setTotalRows(total);
        return criteria;
    }

    @Override
    @Transactional
    public void batchCreateSiteMessage(SiteMessageOutbox outbox, List<SiteMessageInbox> inboxs) {
        logger.info("...createAndSaveMessageQueue start ====> outbox=" + outbox + " inboxs="+inboxs);
        if (null != outbox && inboxs != null && inboxs.size() > 0) {
            this.insertSiteMessageOutbox(outbox);
            siteMessageMapper.batchCreateSiteMessageInbox(inboxs);
        }
    }

	@Override
	public int getSiteMessageInboxCount(SiteMessageInboxCriteria criteria) {
		return siteMessageMapper.getSiteMessageInboxTotal(criteria);
	}

	@Override
	public int getSiteMessageOutboxCount(SiteMessageOutboxCriteria criteria) {
		// TODO Auto-generated method stub
		return siteMessageMapper.getSiteMessageOutboxTotal(criteria);
	}
	
	@Override
	public List<SiteMessageInbox> selectSiteMessageInboxList(
			SiteMessageInboxCriteria criteria) {
		// TODO Auto-generated method stub
		List<SiteMessageInbox> messageInboxs = siteMessageMapper.getSiteMessageInboxList(criteria);
		if(messageInboxs !=null)
			return messageInboxs;
		return new ArrayList<SiteMessageInbox>();
	}

}
