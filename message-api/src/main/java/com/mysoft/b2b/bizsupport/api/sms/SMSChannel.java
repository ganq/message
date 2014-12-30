/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.sms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月13日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

@SuppressWarnings("serial")
public class SMSChannel implements Serializable {

    /**
     * 
     */
    private String smsChannelId;
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
     * 是否可用：0不可用，1可用
     */
    private boolean enabled;
    /**
     * 提供服务类型：1，http；2，webservice
     */
    private int serviceType;
    /**
     * 所有费用
     */
    private BigDecimal allCost;
    /**
     * 已经使用费用
     */
    private BigDecimal usedCost;
    /**
     * 剩余费用
     */
    private BigDecimal surplusCost;
    /**
     * 使用数量
     */
    private int usedNum;
    /**
     * 实现类路径
     */
    private String serviceClass;
    /**
     * 描述
     */
    private String remark;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    private Date lastModifiedTime;

    public String getSmsChannelId() {
        return smsChannelId;
    }

    public void setSmsChannelId(String smsChannelId) {
        this.smsChannelId = smsChannelId;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getAllCost() {
        return allCost;
    }

    public void setAllCost(BigDecimal allCost) {
        this.allCost = allCost;
    }

    public BigDecimal getUsedCost() {
        return usedCost;
    }

    public void setUsedCost(BigDecimal usedCost) {
        this.usedCost = usedCost;
    }

    public BigDecimal getSurplusCost() {
        return surplusCost;
    }

    public void setSurplusCost(BigDecimal surplusCost) {
        this.surplusCost = surplusCost;
    }

    public int getUsedNum() {
        return usedNum;
    }

    public void setUsedNum(int usedNum) {
        this.usedNum = usedNum;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
