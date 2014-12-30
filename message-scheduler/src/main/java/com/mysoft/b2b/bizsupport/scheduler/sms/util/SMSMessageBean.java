package com.mysoft.b2b.bizsupport.scheduler.sms.util;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.sms.SMSJob;
import com.mysoft.b2b.bizsupport.scheduler.sms.SMSConfig;

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

public class SMSMessageBean {

    protected SMSJob job;

    protected SMSConfig config;
    
    private List<String> mobiles;

    private List<String> successlist;

    private List<String> faillist;
    
    public SMSMessageBean(){
        
    }
    
    public SMSMessageBean(SMSJob job, SMSConfig config){
        this(job, config, null);
    }

    public SMSMessageBean(SMSJob job, SMSConfig config, List<String> mobiles){
        this.job = job;
        this.config = config;
        this.mobiles = mobiles;
    }
    
    public SMSJob getJob() {
        return job;
    }

    public void setJob(SMSJob job) {
        this.job = job;
    }

    public SMSConfig getConfig() {
        return config;
    }

    public void setConfig(SMSConfig config) {
        this.config = config;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public List<String> getSuccesslist() {
        return successlist;
    }

    public void setSuccesslist(List<String> successlist) {
        this.successlist = successlist;
    }

    public List<String> getFaillist() {
        return faillist;
    }

    public void setFaillist(List<String> faillist) {
        this.faillist = faillist;
    }

}
