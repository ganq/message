package com.mysoft.b2b.bizsupport.scheduler.email;

import java.util.List;

/**
 * 发送邮件服务
 * @author lvzj
 *
 */
public interface EmailSendService {
	
	/**
	 * 发送邮件
	 * @param content       正文内容
	 * @param title         主题 （邮件标题）
	 * @param receiverList	接收列表
	 * @param attList	              附件列表
	 * @return
	 */
	boolean sendEmail(String content, String title, List<String> receiverList,List<EmailAttachment> attList);
	
}
