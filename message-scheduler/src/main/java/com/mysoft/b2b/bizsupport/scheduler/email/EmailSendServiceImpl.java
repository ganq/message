/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.email;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysoft.b2b.commons.exception.PlatformUncheckException;

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
@Service("emailService")
public class EmailSendServiceImpl implements EmailSendService {

    /**
     * 邮件会话
     */
    private static Session session;

    private static Logger log = Logger.getLogger(EmailSendServiceImpl.class);

    @Autowired
    private EmailInfo emailInfo;

    @Override
    public boolean sendEmail(String content, String title, List<String> receiverList, List<EmailAttachment> attList) {
        log.info("SendEmail start .....param={context=" + content + ",title=" + title + ",receiverList=" + receiverList.toString());
        if(StringUtils.isBlank(content) || null == receiverList){
            log.error("SendEmail end....., bad parameters.");
            throw new PlatformUncheckException("SendEmail (sendEmail) exception:bad parameters.", null);
        }
        
        Session sendMailSession = this.getEmailSession();
        try {
            Message mailMessage = new MimeMessage(sendMailSession);
            
            Address[] addresses = new Address[receiverList.size()];
            for (int i = 0; i < receiverList.size(); i++) {
                addresses[i] = new InternetAddress(receiverList.get(i));
            }
            mailMessage.setFrom(new InternetAddress(emailInfo.getEmailFrom()));
            mailMessage.setSubject(title);
            mailMessage.setRecipients(RecipientType.TO, addresses);
            mailMessage.setContent(createMimeMultiPart(content, attList));
            
            Transport.send(mailMessage);
            
            log.info("SendEmail end..... success ");
        } catch (PlatformUncheckException e) {
            log.error("SendEmail end..... " + e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error("SendEmail end..... " + e.getMessage(), e);
            throw new PlatformUncheckException("SendEmail (-createContent) exception:"+e, null, e.getCause());
        }
        return true;
    }

    /**
     * 生成正文，包括附件
     * @param content
     * @param attList
     * @return
     */
    private MimeMultipart createMimeMultiPart(String content, List<EmailAttachment> attList) {
        // 将邮件中各个部分组合到一个"mixed"型的 MimeMultipart 对象  
        log.info("SendEmail (-createMimeMultiPart) start..... ");
        MimeMultipart mime = new MimeMultipart("mixed");
        
        MimeBodyPart contentPart = null;
        try {
            log.info("SendEmail (-create Content) end..... ");
            contentPart = new MimeBodyPart();
            // 用于组合文本和图片，"related"型的MimeMultipart对象  
            MimeMultipart contentMultipart = new MimeMultipart("related");
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(content, "text/html;charset=utf-8");
            contentMultipart.addBodyPart(htmlPart);
            contentPart.setContent(contentMultipart);
            mime.addBodyPart(contentPart);
            log.info("SendEmail (-create Content) end..... ");
        } catch (Exception e) {
            log.error("SendEmail (-create Content) end..... " + e.getMessage(), e);
            throw new PlatformUncheckException("SendEmail (-create Content) exception:"+e, null, e.getCause());
        }
        
        try {
            log.info("SendEmail (-create Attachment) start..... ");
            if (null != attList && !attList.isEmpty()) {
                MimeBodyPart part = null;
                for (EmailAttachment att : attList) {
                    //附件
                    part = new MimeBodyPart();
                    part.setDataHandler(new DataHandler(new ByteArrayDataSource(att.getBs(), "application/octet-stream")));
                    part.setFileName(att.getFileName());
                    mime.addBodyPart(part);
                }
            }
            log.info("SendEmail (-create Attachment) end..... ");
        } catch (Exception e) {
            log.error("SendEmail (-create Attachment) end..... " + e.getMessage(), e);
            throw new PlatformUncheckException("SendEmail (-create Attachment) exception:"+e, null, e.getCause());
        }
        log.info("SendEmail (-createMimeMultiPart) end..... ");
        return mime;
    }

    /**
     * 获取发送邮件会话
     */
    private Session getEmailSession() {
        if (session == null) {
            Properties property = new Properties();
            property.put("mail.smtp.host", emailInfo.getEmailServerHost());
            property.put("mail.smtp.port", emailInfo.getEmailServerPort());
            property.setProperty("mail.smtp.auth", "true");
            MyAuthenticator authenticator = new MyAuthenticator(emailInfo.getUserName(), emailInfo.getPassword());
            session = Session.getDefaultInstance(property, authenticator);
        }
        return session;
    }
    
}
