/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.sms;

import org.apache.commons.lang.StringUtils;

import com.mysoft.b2b.bizsupport.api.sms.SMSChannel;
import com.mysoft.b2b.bizsupport.scheduler.sms.util.ChannelService;
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

public class SMSConfig {

    
    private String channelId;
    /**
     * 企业编号
     */
    private String code;

    /**
     * 帐号
     */
    private String user;

    /**
     * 密码
     */
    private String password;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 提供服务类型：1，http；2，webservice；3。db
     */
    private int serviceType;

    /**
     * 实现类路径
     */
    private String serviceClass;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public SMSChannel getSMSChannel(){
        SMSChannel smsChannel = new SMSChannel();
        smsChannel.setSmsChannelId(channelId);
        smsChannel.setCode(code);
        smsChannel.setUser(user);
        smsChannel.setPassword(password);
        smsChannel.setUrl(url);
        smsChannel.setServiceType(serviceType);
        smsChannel.setServiceClass(serviceClass);
        return smsChannel;
    }
    
    public ChannelService getChannelService(){
        if(StringUtils.isNotEmpty(this.getServiceClass())){
            if(this.getServiceClass().indexOf(".")>-1){
                try {
                    return (ChannelService)(Class.forName(this.getServiceClass())).newInstance();
                } catch (Exception e) {
                    return null;
                }
            }else{
                return SpringContextAware.getBean(this.getServiceClass());
            }
        }
        return null;
    }
}
