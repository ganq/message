/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.provider;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInboxCriteria;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutboxCriteria;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageService;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;

/**
 * Administrator: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * Administrator    1.0           2014年8月20日     Created
 *
 * </pre>
 * @since b2b 1.5.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMessageServiceImplTest extends BaseTestCase{
	
	@Autowired
	private SiteMessageService siteMessageService;

	@Test
	public void testInsertSiteMessageInbox() {
		SiteMessageInbox inbox = new SiteMessageInbox();
		inbox.setAttachments("附件1");
		inbox.setContent("content1");
		inbox.setDeleted(false);
		inbox.setMessageBatch("messageBatch");
		inbox.setMessageTypeCode("messageTypeCode");
		inbox.setReaded(true);
		inbox.setReadedTime(new Date());
		inbox.setReceivedTime(new Date());
		inbox.setReceiver("receiver1");
		inbox.setReceiverId("recieverid1");
		inbox.setSender("sender1");
		inbox.setSenderId("senderid1");
		inbox.setTitle("title1");
		siteMessageService.insertSiteMessageInbox(inbox);
		
		inbox = new SiteMessageInbox();
        inbox.setAttachments("附件1");
        inbox.setContent("content1");
        inbox.setDeleted(false);
        inbox.setMessageBatch("messageBatch1");
        inbox.setMessageTypeCode("messageTypeCode");
        inbox.setReaded(true);
        inbox.setReadedTime(new Date());
        inbox.setReceivedTime(new Date());
        inbox.setReceiver("receiver1");
        inbox.setReceiverId("recieverid1");
        inbox.setSender("sender1");
        inbox.setSenderId("senderid1");
        inbox.setTitle("title1");
        siteMessageService.insertSiteMessageInbox(inbox);
	}

    @Test
    public void testGetSiteMessageInboxList() {
        SiteMessageInboxCriteria criteria = new SiteMessageInboxCriteria();
        criteria.setTitle("title");
        criteria.setContent("content");
        criteria.setMessageBatch("messageBatch");
        criteria.setMessageTypeCode("messageTypeCode");
        criteria.setPageSize(10);
        criteria.setIsDeleted(false);
        criteria = siteMessageService.getSiteMessageInboxList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }
    
    @Test
    public void testGetSiteMessageInbox() {
        SiteMessageInboxCriteria criteria = new SiteMessageInboxCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = siteMessageService.getSiteMessageInboxList(criteria);
        SiteMessageInbox inbox = criteria.getList().get(0);
        inbox = siteMessageService.getSiteMessageInbox(inbox.getInboxId());
        Assert.assertTrue(inbox!=null);
    }
    
	@Test
	public void testUpdateSiteMessageInbox() {
	    SiteMessageInboxCriteria criteria = new SiteMessageInboxCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = siteMessageService.getSiteMessageInboxList(criteria);
        SiteMessageInbox inbox = criteria.getList().get(0);
        inbox = siteMessageService.getSiteMessageInbox(inbox.getInboxId());
		inbox.setTitle("_title");
		siteMessageService.updateSiteMessageInbox(inbox);
		
		criteria = siteMessageService.getSiteMessageInboxList(criteria);
        inbox = criteria.getList().get(0);
        
		Assert.assertTrue(inbox.getTitle().equals("_title"));
	}

	@Test
	public void testDeleteSiteMessageInboxSiteMessageInbox() {
	    SiteMessageInboxCriteria criteria = new SiteMessageInboxCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = siteMessageService.getSiteMessageInboxList(criteria);
        SiteMessageInbox inbox = criteria.getList().get(0);
		siteMessageService.deleteSiteMessageInbox(inbox);
		
		criteria = siteMessageService.getSiteMessageInboxList(criteria);
		Assert.assertTrue(criteria.getList().size() == 0);
	}

	@Test
	public void testDeleteSiteMessageInboxString() {
	    SiteMessageInboxCriteria criteria = new SiteMessageInboxCriteria();
        criteria.setMessageBatch("messageBatch1");
        criteria = siteMessageService.getSiteMessageInboxList(criteria);
        SiteMessageInbox inbox = criteria.getList().get(0);
		siteMessageService.deleteSiteMessageInbox(inbox.getInboxId());

        criteria = siteMessageService.getSiteMessageInboxList(criteria);
		Assert.assertTrue(criteria.getList().size() == 0);
	}

	@Test
	public void testInsertSiteMessageOutbox() {
		SiteMessageOutbox outbox = new SiteMessageOutbox();
		outbox.setAttachments("附件1");
		outbox.setContent("content1");
		outbox.setDeleted(false);
		outbox.setMessageBatch("messageBatch");
		outbox.setMessageTypeCode("messageTypeCode");
		outbox.setReceiver("receiver1");
		outbox.setSender("sender1");
		outbox.setSenderId("senderid1");
		outbox.setTitle("title1");
		siteMessageService.insertSiteMessageOutbox(outbox);
		
		outbox = new SiteMessageOutbox();
		outbox.setAttachments("附件1");
		outbox.setContent("content1");
		outbox.setDeleted(false);
		outbox.setMessageBatch("messageBatch1");
		outbox.setMessageTypeCode("messageTypeCode");
		outbox.setReceiver("receiver1");
		outbox.setSender("sender1");
		outbox.setSenderId("senderid1");
		outbox.setTitle("title1");
		siteMessageService.insertSiteMessageOutbox(outbox);
		
	}

    @Test
    public void testGetSiteMessageOutboxList() {
        SiteMessageOutboxCriteria criteria = new SiteMessageOutboxCriteria();
        criteria.setTitle("title");
        criteria.setContent("content");
        criteria.setIsDeleted(false);
        criteria.setAttachments("附件1");
        criteria.setContent("content1");
        criteria.setMessageBatch("messageBatch1");
        criteria.setMessageTypeCode("messageTypeCode");
        criteria.setReceiver("receiver1");
        criteria.setSender("sender1");
        criteria.setSenderId("senderid1");
        criteria = siteMessageService.getSiteMessageOutboxList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }
    
    @Test
    public void testGetSiteMessageOutbox() {
        SiteMessageOutboxCriteria criteria = new SiteMessageOutboxCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = siteMessageService.getSiteMessageOutboxList(criteria);
        SiteMessageOutbox outbox = siteMessageService.getSiteMessageOutbox(criteria.getList().get(0).getOutboxId());
        Assert.assertTrue(outbox != null);
    }

	@Test
	public void testUpdateSiteMessageOutbox() {
	    SiteMessageOutboxCriteria criteria = new SiteMessageOutboxCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = siteMessageService.getSiteMessageOutboxList(criteria);
        SiteMessageOutbox outbox = criteria.getList().get(0);
        
        outbox.setTitle("_TITLE");
        outbox.setDeleted(true);
		siteMessageService.updateSiteMessageOutbox(outbox);
		
		criteria = siteMessageService.getSiteMessageOutboxList(criteria);
		outbox = criteria.getList().get(0);
		
		Assert.assertTrue(outbox.getTitle().equals("_TITLE"));
		Assert.assertTrue(outbox.isDeleted());
	}

	@Test
	public void testDeleteSiteMessageOutboxSiteMessageOutbox() {
	    SiteMessageOutboxCriteria criteria = new SiteMessageOutboxCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = siteMessageService.getSiteMessageOutboxList(criteria);
        SiteMessageOutbox outbox = criteria.getList().get(0);
		siteMessageService.deleteSiteMessageOutbox(outbox);
		criteria = siteMessageService.getSiteMessageOutboxList(criteria);
		Assert.assertTrue(criteria.getList().size()==0);
	}

	@Test
	public void testDeleteSiteMessageOutboxString() {
	    SiteMessageOutboxCriteria criteria = new SiteMessageOutboxCriteria();
        criteria.setMessageBatch("messageBatch1");
        criteria = siteMessageService.getSiteMessageOutboxList(criteria);
        SiteMessageOutbox outbox = criteria.getList().get(0);
        siteMessageService.deleteSiteMessageInbox(outbox.getOutboxId());
        
        criteria = siteMessageService.getSiteMessageOutboxList(criteria);
        Assert.assertTrue(criteria.getList().size()==0);
	}

}
