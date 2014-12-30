/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.mysoft.b2b.bizsupport.api.MessageChannel;
import com.mysoft.b2b.bizsupport.api.MessageContants;
import com.mysoft.b2b.bizsupport.api.MessageReceiver;
import com.mysoft.b2b.bizsupport.api.email.EmailJob;
import com.mysoft.b2b.bizsupport.api.email.EmailService;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueue;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueCriteria;
import com.mysoft.b2b.bizsupport.api.queue.MessageQueueService;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageInbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageOutbox;
import com.mysoft.b2b.bizsupport.api.sitemessage.SiteMessageService;
import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.api.sms.SMSService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.scheduler.util.MysoftJob;
import com.mysoft.b2b.bizsupport.scheduler.util.SpringContextAware;

/**
 * chengp: 消息任务调度
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public class MessageQueueSchedulerJob extends MysoftJob {

    @Override
    public void run() {
        MessageQueueService service = SpringContextAware.getBean(MessageQueueService.class);

        MessageQueueCriteria criteria = new MessageQueueCriteria();
        criteria.setPageSize(10);
        criteria.setCurrentPage(1);
        criteria.setTryTimes(3);
        criteria.setDealtTime(MessageUtil.getDateBefore(3));
        List<MessageQueue> list = service.getSchedulerMessageQueueList(criteria);
        if (list != null && list.size() > 0) {
            for (MessageQueue messageQueue : list) {
                try {
                    this.startToDealJob(messageQueue, service);

                    this.dealMessageQueue(messageQueue);

                    this.finishToDealJob(true, messageQueue, service, null);

                } catch (Exception e) {
					// 处理内容和标题为空的情况
                	try {
						if (StringUtils.isEmpty(messageQueue.getContent())) {
							messageQueue.setContent("空内容");
							messageQueue.setTryTimes(9);
						}
						if (StringUtils.isBlank(messageQueue.getTitle())) {
							messageQueue.setTitle("空内容");
							messageQueue.setTryTimes(9);
						}
						this.finishToDealJob(false, messageQueue, service, e);
					} catch (Exception ex) {
						logger.error("finishToDealJob error, exception:" + ex, ex);
					}
                }
            }
        }
    }

    private void startToDealJob(MessageQueue messageQueue, MessageQueueService service) {
        if (null != messageQueue) {
            messageQueue.setStatus(MessageContants.MESSAGE_QUEUE_STATUS_DEALING);
            messageQueue.setDealtTime(new Date());
            service.updateMessageQueue(messageQueue);
        }
    }

    private void finishToDealJob(boolean flag, MessageQueue messageQueue, MessageQueueService service, Exception e) {
        if (null != messageQueue) {
            if (flag) {
                messageQueue.setStatus(MessageContants.MESSAGE_QUEUE_STATUS_SUCCESS);
                messageQueue.setTryTimes(messageQueue.getTryTimes() + 1);
                service.updateMessageQueue(messageQueue);
            } else {
                messageQueue.setStatus(MessageContants.MESSAGE_QUEUE_STATUS_FAILED);
                messageQueue.setTryTimes(messageQueue.getTryTimes() + 1);
                messageQueue.setRemark(e == null ? null:"操作异常");
                service.updateMessageQueue(messageQueue);
            }
        }
    }

    /**
     * 处理消息队列
     * @param messageQueue
     */
    private void dealMessageQueue(MessageQueue messageQueue) {
        if (null != messageQueue) {
            List<MessageReceiver> receivers = MessageUtil.getObjectArrayByJSON(messageQueue.getReceiver(), MessageReceiver.class);
            if(receivers != null){
                EmailService emailService = SpringContextAware.getBean(EmailService.class);
                SMSService smsService = SpringContextAware.getBean(SMSService.class);
				SiteMessageService siteMessageService = SpringContextAware.getBean(SiteMessageService.class);
                
                List<MessageReceiver> emailReceivers = new ArrayList<MessageReceiver>();
                List<MessageReceiver> smsReceivers = new ArrayList<MessageReceiver>();
                List<MessageReceiver> siteMessageReceivers = new ArrayList<MessageReceiver>();
                List<SiteMessageInbox> inboxs = new ArrayList<SiteMessageInbox>();
                
                for (MessageReceiver messageReceiver : receivers) {
                    if(null != messageReceiver){
                        Map<Integer, String> addrMap = messageReceiver.getAddrMap();
                        String emailAddr = addrMap.get(MessageChannel.EMAIL.getValue());
                        String smsAddr = addrMap.get(MessageChannel.SMS.getValue());
                        String siteMessageAddr = addrMap.get(MessageChannel.SITE_MESSAGE.getValue());
                        if(StringUtils.isNotBlank(emailAddr)){
                            emailReceivers.add(messageReceiver);
                        }
                        
                        if(StringUtils.isNotBlank(smsAddr)){
                            smsReceivers.add(messageReceiver);
                        }
                        
                        if(StringUtils.isNotBlank(siteMessageAddr)){
                            siteMessageReceivers.add(messageReceiver);
                            SiteMessageInbox inbox = converterToSiteMessageInbox(messageQueue, messageReceiver);
                            //inbox.setInboxId(siteMessageService.generateSiteMessageOutboxId());
                            inbox.setInboxId(siteMessageService.generateSiteMessageInboxId());
                            inboxs.add(inbox);
                        }
                    }
                }
                
                if(emailReceivers != null && emailReceivers.size() > 0){
                    emailService.insertEmailJob(converterToEmailJob(messageQueue, emailReceivers));
                }

                if(smsReceivers != null && smsReceivers.size() > 0){
                    smsService.insertSMSJob(converterToSMSJob(messageQueue, smsReceivers));
                }
                
                if(inboxs != null && inboxs.size() > 0){
                    SiteMessageOutbox outbox = converterToSiteMessageOutbox(messageQueue, siteMessageReceivers);
                    siteMessageService.batchCreateSiteMessage(outbox, inboxs);
                }
            }
        }
    }

    private EmailJob converterToEmailJob(MessageQueue messageQueue, List<MessageReceiver> receivers){
        EmailJob job = new EmailJob();
        job.setTitle(messageQueue.getTitle());
        job.setSender(messageQueue.getSender());
        job.setSenderId(messageQueue.getSenderId());
        job.setReceiver(MessageUtil.getJsonByObject(receivers));
        job.setMessageBatch(messageQueue.getMessageBatch());
        job.setMessageTypeCode(messageQueue.getMessageTypeCode());
        job.setContent(messageQueue.getContent());
        job.setAttachments(messageQueue.getAttachments());
        job.setStatus(MessageContants.EMAIL_STATUS_DEFAULT);
        job.setRemark(null);
        job.setTryTimes(0);
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        return job;
    }

    private SMSJob converterToSMSJob(MessageQueue messageQueue, List<MessageReceiver> receivers){
        SMSJob job = new SMSJob();
        job.setTitle(messageQueue.getTitle());
        job.setSender(messageQueue.getSender());
        job.setSenderId(messageQueue.getSenderId());
        job.setReceiver(MessageUtil.getJsonByObject(receivers));
        job.setMessageBatch(messageQueue.getMessageBatch());
        job.setMessageTypeCode(messageQueue.getMessageTypeCode());
        job.setContent(messageQueue.getContent());
        job.setAttachments(messageQueue.getAttachments());
        job.setStatus(MessageContants.EMAIL_STATUS_DEFAULT);
        job.setRemark(null);
        job.setTryTimes(0);
        job.setCreatedTime(new Date());
        job.setLastSentTime(null);
        job.setCallIn(null);
        job.setSmsId(null);
        return job;
    }

    private SiteMessageInbox converterToSiteMessageInbox(MessageQueue messageQueue, MessageReceiver receiver){
        SiteMessageInbox inbox = new SiteMessageInbox();
        inbox.setSender(messageQueue.getSender());
        inbox.setSenderId(messageQueue.getSenderId());
        inbox.setReceiver(receiver.getReceiver());
        inbox.setReceiverId(receiver.getReceiverId());
        inbox.setMessageBatch(messageQueue.getMessageBatch());
        inbox.setMessageTypeCode(messageQueue.getMessageTypeCode());
        inbox.setTitle(messageQueue.getTitle());
        inbox.setContent(messageQueue.getContent());
        inbox.setAttachments(messageQueue.getAttachments());
        inbox.setReaded(false);
        inbox.setDeleted(false);
        inbox.setReadedTime(null);
        inbox.setReceivedTime(messageQueue.getCreatedTime());
        return inbox;
    }

    private SiteMessageOutbox converterToSiteMessageOutbox(MessageQueue messageQueue, List<MessageReceiver> receivers){
        SiteMessageOutbox outbox = new SiteMessageOutbox();
        outbox.setSender(messageQueue.getSender());
        outbox.setSenderId(messageQueue.getSenderId());
        outbox.setReceiver(MessageUtil.getJsonByObject(receivers));
        outbox.setMessageBatch(messageQueue.getMessageBatch());
        outbox.setMessageTypeCode(messageQueue.getMessageTypeCode());
        outbox.setTitle(messageQueue.getTitle());
        outbox.setContent(messageQueue.getContent());
        outbox.setAttachments(messageQueue.getAttachments());
        outbox.setDeleted(false);
        outbox.setSentTime(messageQueue.getCreatedTime());
        return outbox;
    }
    
}
