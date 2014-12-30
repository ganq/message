/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.util;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月22日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public class SchedulerFactory implements InitializingBean {
    
    private List<MysoftJob> jobs;
    
    public void setJobs(List<MysoftJob> jobs) {
        this.jobs = jobs;
    }

    public void afterPropertiesSet() throws Exception {
        if(jobs!= null && jobs.size() > 0){
            
            SchedulerManager.initManager();
            
            JobInfoModel[] jobInfoModels = new JobInfoModel[jobs.size()];
            for (int i = 0; i < jobs.size(); i++) {
                MysoftJob job = jobs.get(i);
                jobInfoModels[i] = SchedulerManager.createJobInfoModel(
                        job.getJobName(), job.getClass(), job.getCronExpression(), job.getParams());
            }
            SchedulerManager.createJobModels(jobInfoModels);
        }
    }

    public List<MysoftJob> getJobs() {
        return jobs;
    }

    public void init(){
        
    }
    
    public void destory(){
        SchedulerManager.destoryManager();
    }
    
}
