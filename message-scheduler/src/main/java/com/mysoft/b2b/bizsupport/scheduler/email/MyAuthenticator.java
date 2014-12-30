package com.mysoft.b2b.bizsupport.scheduler.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */
public class MyAuthenticator extends Authenticator{
	
	private String username;
	private String password;
	
	public MyAuthenticator(String username,String password){
		this.username = username;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
	
}
