/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.email;

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

public class EmailInfo {

    /**
     * 系统发件邮箱
     */
    private String emailFrom;

    /**
     * 邮箱账号
     */
    private String userName;

    /**
     * 邮箱密码
     */
    private String password;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 邮件服务IP
     */
    private String emailServerHost;

    /**
     * 邮件服务端口
     */
    private String emailServerPort;

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailServerHost() {
        return emailServerHost;
    }

    public void setEmailServerHost(String emailServerHost) {
        this.emailServerHost = emailServerHost;
    }

    public String getEmailServerPort() {
        return emailServerPort;
    }

    public void setEmailServerPort(String emailServerPort) {
        this.emailServerPort = emailServerPort;
    }

}
