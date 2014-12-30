/**
 * Copyright ecVision Limited (c) 2012. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of ecVision Limited.  Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from ecVision or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.sms.util;

/**
 * CGP: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * CGP        1.0           2012-11-8     Created
 *
 * </pre>
 * @since Uet1.0
 */

public class SendResultReceipt {

    private String smsId;

    private String phone;

    private String result;

    public SendResultReceipt() {

    }

    public SendResultReceipt(String smsId, String phone, String result) {
        this.smsId = smsId;
        this.phone = phone;
        this.result = result;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
