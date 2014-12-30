package com.mysoft.b2b.bizsupport.scheduler.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mysoft.b2b.commons.exception.PlatformUncheckException;

public class SpringContextAware implements ApplicationContextAware, DisposableBean {

    protected static Logger logger = Logger.getLogger(SpringContextAware.class);

    protected static ApplicationContext applicationContext = null;

    public void destroy() throws Exception {
        logger.info("Destory SpringContextHolder ApplicationContext:" + SpringContextAware.applicationContext);
        SpringContextAware.applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Init SpringContextAware springContextHolder:" + applicationContext);
        if (SpringContextAware.applicationContext != null) {
            logger.warn("SpringContextHolder ApplicationContext ApplicationContext:" + applicationContext);
        }
        SpringContextAware.applicationContext = applicationContext; // NOSONAR
    }

    /**
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return SpringContextAware.applicationContext;
    }

    /**
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     */
    private static void assertContextInjected() {
        if (SpringContextAware.applicationContext == null) {
            throw new PlatformUncheckException("Failed to load applicationContext.xml", null);
        }
    }

}
