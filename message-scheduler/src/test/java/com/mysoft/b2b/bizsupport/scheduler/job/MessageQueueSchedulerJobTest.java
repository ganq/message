/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.scheduler.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.scheduler.BaseTestCase;
import com.mysoft.b2b.bizsupport.scheduler.util.MysoftJob;
import com.mysoft.b2b.bizsupport.scheduler.util.SpringContextAware;

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
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageQueueSchedulerJobTest extends BaseTestCase{

    @Test
    public void testRun() {
        MysoftJob job = SpringContextAware.getBean("messageQueueSchedulerJob");
        job.run();
    }

}
