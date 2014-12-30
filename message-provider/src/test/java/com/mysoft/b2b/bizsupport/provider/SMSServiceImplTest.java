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
import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.api.sms.SMSJobCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSLog;
import com.mysoft.b2b.bizsupport.api.sms.SMSLogCriteria;
import com.mysoft.b2b.bizsupport.api.sms.SMSReply;
import com.mysoft.b2b.bizsupport.api.sms.SMSService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月22日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SMSServiceImplTest extends BaseTestCase {

    @Autowired
    private SMSService smsService;
/*
    @Test
    public void testInsertSMSJob() {
        SMSJob job = new SMSJob();
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
        job.setStatus(MessageContants.EMAIL_STATUS_DEALING);
        job.setTitle("title1");
        job.setTryTimes(0);
        job.setCallIn("123");
        job.setSmsId("123");
        smsService.insertSMSJob(job);

        job = new SMSJob();
        job.setAttachments("附件1");
        job.setContent("内容1");
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        job.setMessageBatch("messageBatch1");
        job.setMessageTypeCode("messageTypeCode");
        job.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        job.setRemark("remark1");
        job.setSender("sender1");
        job.setSenderId("sender_id1");
        job.setStatus(MessageContants.EMAIL_STATUS_DEALING);
        job.setTitle("title1");
        job.setTryTimes(0);
        job.setCallIn("123");
        job.setSmsId("123");
        smsService.insertSMSJob(job);
    }

    @Test
    public void testGetSMSJobList() {
        SMSJobCriteria criteria = new SMSJobCriteria();
        List<Integer> statuss = new ArrayList<Integer>();
        statuss.add(MessageContants.SMS_STATUS_DEALING);
        statuss.add(MessageContants.SMS_STATUS_DEFAULT);
        criteria.setContent("内容1");
        criteria.setMessageBatch("messageBatch");
        criteria.setMessageTypeCode("messageTypeCode");
        criteria.setSender("sender1");
        criteria.setSenderId("sender_id1");
        criteria.setStatus(MessageContants.EMAIL_STATUS_DEALING);
        criteria.setTitle("title1");
        criteria.setTryTimes(3);
        criteria.setLastSentTime(MessageUtil.getDateBefore(0));
        criteria = smsService.getSMSJobList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testUpdateSMSJob() {
        SMSJobCriteria criteria = new SMSJobCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSJobList(criteria);
        SMSJob job = criteria.getList().get(0);
        job.setContent("1111111");
        job = smsService.updateSMSJob(job);
        criteria.setContent("1111111");
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSJobList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testGetSMSJob() {
        SMSJobCriteria criteria = new SMSJobCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSJobList(criteria);
        SMSJob job = criteria.getList().get(0);

        job = smsService.getSMSJob(job.getSmsJobId());
        Assert.assertEquals(true, job != null);
    }

    @Test
    public void testGetSchedulerSMSJobList() {
        SMSJobCriteria criteria = new SMSJobCriteria();
        criteria.setPageSize(10);
        criteria.setCurrentPage(1);
        criteria.setTryTimes(3);
        criteria.setLastSentTime(MessageUtil.getDateBefore(0));
        List<SMSJob> list = smsService.getSchedulerSMSJobList(criteria);
        Assert.assertEquals(true, list.size() > 0);
    }

    @Test
    public void testDeleteSMSJobSMSJob() {
        SMSJobCriteria criteria = new SMSJobCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSJobList(criteria);
        SMSJob job = criteria.getList().get(0);
        smsService.deleteSMSJob(job);

        criteria = smsService.getSMSJobList(criteria);
        Assert.assertEquals(true, criteria.getList().size() == 0);
    }

    @Test
    public void testDeleteSMSJobString() {
        SMSJobCriteria criteria = new SMSJobCriteria();
        criteria.setMessageBatch("messageBatch1");
        criteria = smsService.getSMSJobList(criteria);
        SMSJob job = criteria.getList().get(0);
        smsService.deleteSMSJob(job.getSmsJobId());
        criteria = smsService.getSMSJobList(criteria);
        Assert.assertEquals(true, criteria.getList().size() == 0);
    }

    @Test
    public void testInsertSMSLog() {
        SMSLog log = new SMSLog();
        log.setSmsLogId(smsService.generateSMSJobId());
        log.setAttachments("附件1");
        log.setContent("内容1");
        log.setCreatedTime(new Date());
        log.setLastSentTime(null);
        log.setMessageBatch("messageBatch");
        log.setMessageTypeCode("messageTypeCode");
        log.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        log.setRemark("remark1");
        log.setSender("sender1");
        log.setSenderId("sender_id1");
        log.setStatus(MessageContants.SMS_STATUS_SUCCESS);
        log.setTitle("title1");
        log.setTryTimes(0);
        log.setCallIn("123");
        log.setSmsId("123");
        smsService.insertSMSLog(log);

        log = new SMSLog();
        log.setSmsLogId(smsService.generateSMSJobId());
        log.setAttachments("附件1");
        log.setContent("内容1");
        log.setCreatedTime(new Date());
        log.setLastSentTime(null);
        log.setMessageBatch("messageBatch1");
        log.setMessageTypeCode("messageTypeCode");
        log.setReceiver(MessageUtil.getJsonByObject(getReceivers()));
        log.setRemark("remark1");
        log.setSender("sender1");
        log.setSenderId("sender_id1");
        log.setStatus(MessageContants.SMS_STATUS_SUCCESS);
        log.setTitle("title1");
        log.setTryTimes(0);
        log.setCallIn("123");
        log.setSmsId("123");
        smsService.insertSMSLog(log);
    }

    @Test
    public void testGetSMSLogList() {
        SMSLogCriteria criteria = new SMSLogCriteria();
        List<Integer> statuss = new ArrayList<Integer>();
        statuss.add(MessageContants.SMS_STATUS_DEALING);
        statuss.add(MessageContants.SMS_STATUS_DEFAULT);
        criteria.setContent("内容1");
        criteria.setMessageBatch("messageBatch");
        criteria.setMessageTypeCode("messageTypeCode");
        criteria.setSender("sender1");
        criteria.setSenderId("sender_id1");
        //criteria.setStatus(MessageContants.EMAIL_STATUS_DEALING);
        criteria.setTitle("title1");
        criteria.setLastSentTime(MessageUtil.getDateBefore(0));
        criteria = smsService.getSMSLogList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testUpdateSMSLog() {
        SMSLogCriteria criteria = new SMSLogCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSLogList(criteria);
        SMSLog log = criteria.getList().get(0);

        log.setContent("1111111");
        log = smsService.updateSMSLog(log);
        criteria.setContent("1111111");
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSLogList(criteria);
        Assert.assertTrue(criteria.getList().size() > 0);
    }

    @Test
    public void testGetSMSLog() {
        SMSLogCriteria criteria = new SMSLogCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSLogList(criteria);
        SMSLog log = criteria.getList().get(0);

        log = smsService.getSMSLog(log.getSmsLogId());
        Assert.assertEquals(true, log != null);
    }

    @Test
    public void testDeleteSMSLogSMSLog() {
        SMSLogCriteria criteria = new SMSLogCriteria();
        criteria.setMessageBatch("messageBatch");
        criteria = smsService.getSMSLogList(criteria);
        SMSLog log = criteria.getList().get(0);
        smsService.deleteSMSLog(log);

        criteria = smsService.getSMSLogList(criteria);
        Assert.assertEquals(true, criteria.getList().size() == 0);
    }

    @Test
    public void testDeleteSMSLogString() {
        SMSLogCriteria criteria = new SMSLogCriteria();
        criteria.setMessageBatch("messageBatch1");
        criteria = smsService.getSMSLogList(criteria);
        SMSLog log = criteria.getList().get(0);
        smsService.deleteSMSLog(log.getSmsLogId());

        criteria = smsService.getSMSLogList(criteria);
        Assert.assertEquals(true, criteria.getList().size() == 0);
    }
    */
    @Test
    public void testDealSMSReply() {
    	List<SMSReply> replyList = new ArrayList<SMSReply>();
    	SMSReply sr = new SMSReply();
    	sr.setMobile("13632637667");
    	sr.setContent("td");
    	sr.setRecvTime(new Date());
    	replyList.add(sr);
        boolean isSucc = smsService.dealSMSReply(replyList);
    }
}
