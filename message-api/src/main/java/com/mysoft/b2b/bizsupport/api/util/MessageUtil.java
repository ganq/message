/**
 * Copyright mysoft Limited (c) 2014. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of mysoft Limited. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from mysoft or an authorized sublicensor.
 */
package com.mysoft.b2b.bizsupport.api.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.mysoft.b2b.bizsupport.api.MessageChannel;
import com.mysoft.b2b.bizsupport.api.MessageReceiver;
import com.mysoft.b2b.commons.DomainUtil;
import com.mysoft.b2b.commons.exception.PlatformUncheckException;

/**
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月21日     Created
 *
 * </pre>
 * @since b2b 2.0.0
 */

public abstract class MessageUtil {

    /**
     * 取当前时间
     * 
     * @return String
     */
    public static String getNowDate() {
        return formateDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化时间
     * @return String
     */
    public static String formateDate(Date date) {
        return formateDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formateDate(Date date, String formater) {
        SimpleDateFormat format = new SimpleDateFormat(formater);
        String datetime = null;
        try {
            datetime = format.format(date);
        } catch (Exception e) {
            throw new PlatformUncheckException(e.getMessage(), null, e);
        }
        return datetime;
    }

    /**
     * 将模板中的变量替换为入参
     * @param content
     * @param parameters
     * @return
     */
    public static String replaceVariable(String content, Map<String, String> parameters) {
        if (StringUtils.isNotEmpty(content) && !parameters.isEmpty()) {
            Map<String, String> model = enrichParameters(parameters);
            Set<String> ketSet = model.keySet();
            if (!ketSet.isEmpty()) {
                Iterator<String> it = ketSet.iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    String variable = "${".concat(key).concat("}");
                    String variable1 = "#{".concat(key).concat("}");
                    String variable2 = "#".concat(key).concat("#");
                    while (content.indexOf(variable) > -1) {
                        content = content.replace(variable, model.get(key));
                    }
                    while (content.indexOf(variable1) > -1) {
                        content = content.replace(variable1, model.get(key));
                    }
                    while (content.indexOf(variable2) > -1) {
                    	content = content.replace(variable2, model.get(key));
                    }
                }
            }
        }
        return content;
    }
    
    /**
     * 丰富入参，加入域名设置,当前时间
     * @param parameters
     * @return
     */
    private static Map<String, String> enrichParameters(Map<String, String> parameters) {
        parameters.put("date", formateDate(new Date(), "yyyy-MM-dd"));
        parameters.put("mainpage", DomainUtil.getDomain("mainpage"));
        parameters.put("search", DomainUtil.getDomain("mainpage") + "/bidding.html");
        parameters.put("jcs.static", DomainUtil.getDomain("jcs.static"));
        parameters.put("kfs.search", DomainUtil.getDomain("mainpage") + "/developer.html");
        parameters.put("gys.search", DomainUtil.getDomain("mainpage") + "/supplier.html");
        parameters.put("zixun.search", DomainUtil.getDomain("info"));
        return parameters;
    }
    
    /**
     * 获取对象JSON字符串
     * @param obj
     * @return
     */
    public static String getJsonByObject(Object obj){
        return JSON.toJSONString(obj);
    }
    
    /**
     * 依据JSON字符串获取对象
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T getObjectByJSON(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

    /**
     * 依据JSON字符串获取对象集合
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> getObjectArrayByJSON(String json, Class<T> clazz){
        return JSON.parseArray(json, clazz);
    }
    
    /**
     * 获取过去的时间
     * @param minutes
     * @return
     */
    public static Date getDateBefore(int minutes){
        Date date = new Date();
        long Time = (date.getTime() / 1000) - 60 * minutes;
        date.setTime(Time * 1000);
        return date;
    }
    
    /**
     * 获取分页偏离量
     * @param page
     * @param currentPage
     * @return
     */
    public static int getPageOffset(int pageSize, int currentPage){
        if(0 == currentPage || 1 == currentPage){
            return 0;
        }else{
            if(0 == pageSize){
                return 10*(Math.abs(currentPage)-1);
            }else{
                return Math.abs(pageSize)*(Math.abs(currentPage)-1);
            }
        }
    }

    public static void main(String[] args) {
        List<MessageReceiver> list = new ArrayList<MessageReceiver>();
        
        Map<Integer, String> addrMap1 = new HashMap<Integer,String>();
        addrMap1.put(MessageChannel.SITE_MESSAGE.getValue(),"123");
        list.add(new MessageReceiver("123","123", addrMap1));
        
        Map<Integer, String> addrMap2 = new HashMap<Integer,String>();
        addrMap2.put(MessageChannel.SITE_MESSAGE.getValue(),"456");
        list.add(new MessageReceiver("456","456", addrMap2));
        
        String jsonStr = getJsonByObject(list);
        System.out.println(jsonStr);
        List<MessageReceiver> list1 = getObjectArrayByJSON(jsonStr, MessageReceiver.class);
        System.out.println(list1);
        
        System.out.println(getPageOffset(0,1));
    }
    
}
