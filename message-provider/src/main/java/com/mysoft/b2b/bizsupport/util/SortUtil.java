/**
 * 
 */
package com.mysoft.b2b.bizsupport.util;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import com.mysoft.b2b.commons.exception.PlatformUncheckException;

/**
 * 
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月20日     Created
 *
 * </pre>
 * @since 8.
 */
public class SortUtil {

    public static final int SORT_VALUE_TYPE_INT = 1;

    public static final int SORT_VALUE_TYPE_STRING = 2;

    public static final int STATUS_DEATH = 0;

    public static final int STATUS_LIVENESS = 1;

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
     * 字符是否为null或者空串
     * @param  value    字符
     * @return boolean
     */
    public static boolean isNullOrEmpty(final String value) {
        if (value == null || value.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 根据属性名获取属性值
     * 
     * @param bean
     *            对象
     * @param name
     *            属性名
     * @return 属性值
     */
    public static String getValueByProperty(final Object bean, final String name) {
        String value = null;
        Object o;
        try {
            o = BeanUtils.getPropertyDescriptor(bean.getClass(), name).getReadMethod().invoke(bean);
            if (o != null) {
                value = o.toString();
            }
        } catch (BeansException e) {
            throw new PlatformUncheckException(e.getMessage(), null, e);
        } catch (IllegalArgumentException e) {
            throw new PlatformUncheckException(e.getMessage(), null, e);
        } catch (IllegalAccessException e) {
            throw new PlatformUncheckException(e.getMessage(), null, e);
        } catch (InvocationTargetException e) {
            throw new PlatformUncheckException(e.getMessage(), null, e);
        }

        return value;
    }

    /**
     * 集合是否为空
     * 
     * @param collection
     *            集合
     * @return boolean
     */
    @SuppressWarnings("rawtypes")
    public static boolean checkIsNullOrEmpty(final Collection collection) {
        if (collection == null) {
            return true;
        }
        if (collection.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 根据属性名按升序排序List
     * 
     * @param listBean
     *            Beand List
     * @param property
     *            排序属性名
     * @param valueType
     *            属性值类型
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void sortListByPropertyInAsc(final List listBean, final String property, final int valueType) {
        if (checkIsNullOrEmpty(listBean)) {
            return;
        }
        Collections.sort(listBean, new Comparator() {
            public int compare(final Object obj0, final Object obj1) {
                String val0 = getValueByProperty(obj0, property);
                if (isNullOrEmpty(val0)) {
                    val0 = "0";
                }
                String val1 = getValueByProperty(obj1, property);
                if (isNullOrEmpty(val1)) {
                    val1 = "0";
                }
                if (valueType == SORT_VALUE_TYPE_INT) {
                    long i0 = Long.parseLong(val0);
                    long i1 = Long.parseLong(val1);
                    if (i0 == i1) {
                        return 0;
                    } else if (i0 > i1) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return val0.compareTo(val1);
                }
            }
        });
    }

    /**
     * 多属性按字符升序排序List
     * 
     * @param listBean
     *            Beand List
     * @param properties
     *            排序属性名(example: name01,name02,name03)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void sortListByPropertiesInAsc(final List listBean, final String properties) {
        if (checkIsNullOrEmpty(listBean)) {
            return;
        }
        Collections.sort(listBean, new Comparator() {
            public int compare(final Object obj0, final Object obj1) {
                String val0;
                String val1;
                int result = 0;
                String[] names = properties.split(",");
                for (int i = 0; i < names.length; i++) {
                    val0 = getValueByProperty(obj0, names[i]);
                    if (isNullOrEmpty(val0)) {
                        val0 = "0";
                    }
                    val1 = getValueByProperty(obj1, names[i]);
                    if (isNullOrEmpty(val1)) {
                        val1 = "0";
                    }
                    result = val0.compareTo(val1);
                    if (result != 0) {
                        break;
                    }
                }

                return result;
            }
        });
    }
    
}
