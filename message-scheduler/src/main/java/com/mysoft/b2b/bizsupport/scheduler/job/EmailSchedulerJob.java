/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.job;

import java.util.Date;
import java.util.List;

import com.mysoft.b2b.bizsupport.api.MessageChannel;
import com.mysoft.b2b.bizsupport.api.MessageContants;
import com.mysoft.b2b.bizsupport.api.email.EmailJob;
import com.mysoft.b2b.bizsupport.api.email.EmailJobCriteria;
import com.mysoft.b2b.bizsupport.api.email.EmailService;
import com.mysoft.b2b.bizsupport.api.util.MessageUtil;
import com.mysoft.b2b.bizsupport.scheduler.email.EmailSendService;
import com.mysoft.b2b.bizsupport.scheduler.util.MysoftJob;
import com.mysoft.b2b.bizsupport.scheduler.util.SpringContextAware;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public class EmailSchedulerJob extends MysoftJob {

    @Override
    public void run() {
        EmailService emailService = SpringContextAware.getBean(EmailService.class);

        EmailJobCriteria criteria = new EmailJobCriteria();
        criteria.setCurrentPage(1);
        criteria.setPageSize(5);
        criteria.setTryTimes(3);
        criteria.setLastSentTime(MessageUtil.getDateBefore(3));
        List<EmailJob> jobs = emailService.getSchedulerEmailJobList(criteria);
        if (jobs != null && jobs.size() > 0) {
            EmailSendService emailSendService = SpringContextAware.getBean(EmailSendService.class);

            for (EmailJob job : jobs) {
                try {
                    this.startToDealJob(job, emailService);

                    emailSendService.sendEmail(job.getContent(), job.getTitle(),
                            getReceiverList(job.getReceiver(), MessageChannel.EMAIL.getValue()), null);

                    this.finishToDealJob(true, job, emailService, null);
                } catch (Exception e) {
                    this.finishToDealJob(false, job, emailService, e);
                }
            }
        }
    }

    private void startToDealJob(EmailJob job, EmailService emailService) {
        if (job != null) {
            job.setStatus(MessageContants.EMAIL_STATUS_DEALING);
            job.setLastSentTime(new Date());
            emailService.updateEmailJob(job);
        }
    }

    private void finishToDealJob(boolean flag, EmailJob job, EmailService emailService, Exception e) {
        if (job != null) {
            job.setTryTimes(job.getTryTimes() + 1);
            if (flag) {
                job.setRemark("发送至邮件服务器成功！");
                job.setStatus(MessageContants.EMAIL_STATUS_SUCCESS);
                emailService.dealEmailJob(flag, job);
            } else {
                if (e != null) {
                    job.setRemark(e.getMessage());
                }
                job.setStatus(MessageContants.EMAIL_STATUS_FAILED);
                emailService.dealEmailJob(flag, job);
            }
        }
    }

}
