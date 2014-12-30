/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.util;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

public final class ThreadPoolManager {
    
    private static ThreadPoolManager manager = new ThreadPoolManager();
    
    private ThreadPoolExecutor pool;
    
    private ThreadPoolManager(){
        pool = new ThreadPoolExecutor(10,35,5,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100),new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static boolean addTask(Runnable run){
        manager.pool.execute(run);
        return true;
    }
    
    public static ThreadInfo getThreadPoolShotsnap(){
        ThreadInfo domain=new ThreadInfo();
        domain.setActiveCount(manager.pool.getActiveCount());
        domain.setCompletedTaskCount(manager.pool.getCompletedTaskCount());
        domain.setCorePoolSize(manager.pool.getCorePoolSize());
        domain.setMaximumPoolSize(manager.pool.getMaximumPoolSize());
        domain.setPoolSize(manager.pool.getPoolSize());
        domain.setLargestPoolSize(manager.pool.getLargestPoolSize());
        domain.setTaskCount(manager.pool.getTaskCount());
        domain.setCreateDate(new Date());
        return domain;
    }
    
}
