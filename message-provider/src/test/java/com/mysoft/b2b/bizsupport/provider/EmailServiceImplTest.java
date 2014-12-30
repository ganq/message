/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.MessageContants;
import com.mysoft.b2b.bizsupport.api.email.EmailJob;
import com.mysoft.b2b.bizsupport.api.email.EmailJobCriteria;
import com.mysoft.b2b.bizsupport.api.email.EmailLog;
import com.mysoft.b2b.bizsupport.api.email.EmailLogCriteria;
import com.mysoft.b2b.bizsupport.api.email.EmailService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;

/**
 * Administrator: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * Administrator    1.0           2014年8月18日     Created
 *
 * </pre>
 * @since b2b 1.5.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class EmailServiceImplTest extends BaseTestCase {

    @Autowired
    private EmailService emailService;

    @Test
    public void testInsertEmailJob() {
        EmailJob job = new EmailJob();
        job.setAttachments("附件1");
        job.setContent("内容1");
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        job.setMessageBatch("messageBatch");
        job.setMessageTypeCode("messageTypeCode");

        job.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        job.setRemark("remark1");
        job.setSender("sender1");
        job.setSenderId("sender_id1");
        job.setStatus(MessageContants.EMAIL_STATUS_DEFAULT);
        job.setTitle("title1");
        job.setTryTimes(0);
        emailService.insertEmailJob(job);

        job = new EmailJob();
        job.setAttachments("附件1");
        job.setContent("内容1");
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        job.setMessageBatch("messageBatch2");
        job.setMessageTypeCode("messageTypeCode");
        job.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        job.setRemark("remark1");
        job.setSender("sender1");
        job.setSenderId("sender_id1");
        job.setStatus(MessageContants.EMAIL_STATUS_DEFAULT);
        job.setTitle("title1");
        job.setTryTimes(0);
        emailService.insertEmailJob(job);

    }

    @Test
    public void testGetEmailJobList() {
        EmailJobCriteria criteria = new EmailJobCriteria();
        List<Integer> statuss = new ArrayList<Integer>();
        statuss.add(MessageContants.EMAIL_STATUS_FAILED);
        statuss.add(MessageContants.EMAIL_STATUS_DEFAULT);
        criteria.setContent("内容1");
        criteria.setMessageBatch("messageBatch");
        criteria.setMessageTypeCode("messageTypeCode");
        criteria.setReceiver("chengp");
        criteria.setSender("sender1");
        criteria.setSenderId("sender_id1");
        criteria.setStatus(MessageContants.EMAIL_STATUS_DEFAULT);
        criteria.setTitle("title1");
        criteria.setTryTimes(3);
        criteria.setLastSentTime(MessageUtil.getDateBefore(0));
        criteria = emailService.getEmailJobList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testGetEmailJob() {
        EmailJobCriteria criteria = new EmailJobCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailJobList(criteria);
        EmailJob job = criteria.getList().get(0);

        job = emailService.getEmailJob(job.getEmailJobId());
        Assert.assertEquals(true, job != null);
    }

    @Test
    public void testUpdateEmailJob() {
        EmailJobCriteria criteria = new EmailJobCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailJobList(criteria);
        EmailJob job = criteria.getList().get(0);
        job.setContent("1111111");
        job = emailService.updateEmailJob(job);
        criteria.setContent("1111111");
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailJobList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testGetSchedulerEmailJobList() {
        EmailJobCriteria criteria = new EmailJobCriteria();
        criteria.setPageSize(10);
        criteria.setCurrentPage(1);
        criteria.setTryTimes(3);
        criteria.setLastSentTime(MessageUtil.getDateBefore(0));
        List<EmailJob> list = emailService.getSchedulerEmailJobList(criteria);
        Assert.assertEquals(true, list.size() > 0);
    }

    @Test
    public void testDeleteEmailJobEmailJob() {
        EmailJobCriteria criteria = new EmailJobCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailJobList(criteria);
        emailService.deleteEmailJob(criteria.getList().get(0));
    }

    @Test
    public void testDeleteEmailJobString() {
        EmailJobCriteria criteria = new EmailJobCriteria();
        criteria.setMessageBatch("messageBatch2");
        criteria = emailService.getEmailJobList(criteria);
        emailService.deleteEmailJob(criteria.getList().get(0).getEmailJobId());
    }

    @Test
    public void testInsertEmailLog() {
        EmailLog job = new EmailLog();
        job.setAttachments("附件1");
        job.setContent("内容1");
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        job.setMessageBatch("messageBatch");
        job.setMessageTypeCode("messageTypeCode");
        job.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        job.setRemark("remark1");
        job.setSender("sender1");
        job.setSenderId("sender_id1");
        job.setStatus(MessageContants.EMAIL_STATUS_SUCCESS);
        job.setTitle("title1");
        job.setTryTimes(0);
        emailService.insertEmailLog(job);

        job = new EmailLog();
        job.setAttachments("附件1");
        job.setContent("内容1");
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        job.setMessageBatch("messageBatch2");
        job.setMessageTypeCode("messageTypeCode");
        job.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        job.setRemark("remark1");
        job.setSender("sender1");
        job.setSenderId("sender_id1");
        job.setStatus(MessageContants.EMAIL_STATUS_SUCCESS);
        job.setTitle("title1");
        job.setTryTimes(0);
        emailService.insertEmailLog(job);
    }

    @Test
    public void testUpdateEmailLog() {
        EmailLogCriteria criteria = new EmailLogCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailLogList(criteria);
        EmailLog job = criteria.getList().get(0);
        job.setContent("2222222");
        ;
        emailService.updateEmailLog(job);
    }

    @Test
    public void testGetEmailLog() {
        EmailLogCriteria criteria = new EmailLogCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailLogList(criteria);
        EmailLog log = emailService.getEmailLog(criteria.getList().get(0).getEmailLogId());
        Assert.assertTrue(log != null);
    }

    @Test
    public void testGetEmailLogList() {
        EmailLogCriteria criteria = new EmailLogCriteria();
        criteria.setTitle("title");
        criteria.setStatus(MessageContants.EMAIL_STATUS_SUCCESS);
        List<Integer> statuss = new ArrayList<Integer>();
        statuss.add(MessageContants.EMAIL_STATUS_SUCCESS);
        criteria.setReceiver("chengp");
        criteria.setSender("sender3");
        criteria.setContent("内容");
        criteria.setPageSize(10);
        criteria.setCurrentPage(1);
        criteria = emailService.getEmailLogList(criteria);
        criteria.getContent();
    }

    @Test
    public void testDeleteEmailLogEmailLog() {
        EmailLogCriteria criteria = new EmailLogCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = emailService.getEmailLogList(criteria);
        emailService.deleteEmailLog(criteria.getList().get(0));

        criteria = emailService.getEmailLogList(criteria);
        Assert.assertTrue(criteria.getList().size() == 0);
    }

    @Test
    public void testDeleteEmailLogString() {
        EmailLogCriteria criteria = new EmailLogCriteria();
        criteria.setMessageBatch("messageBatch2");
        criteria = emailService.getEmailLogList(criteria);
        emailService.deleteEmailLog(criteria.getList().get(0).getEmailLogId());

        criteria = emailService.getEmailLogList(criteria);
        Assert.assertTrue(criteria.getList().size() == 0);
    }

}
