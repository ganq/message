package com.mysoft.b2b.bizsupport.scheduler.sms.util;

/**
 * 
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since 8.
 */
public class SendResultBean {

    private int result;

    private String faillist;

    private String description;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getFaillist() {
        return faillist;
    }

    public void setFaillist(String faillist) {
        this.faillist = faillist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
