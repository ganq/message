/**
 * SmsRecvGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri;

public class SmsRecvGroup  implements java.io.Serializable {
    private java.lang.String mobile;

    private java.lang.String recvNum;

    private java.lang.String addNum;

    private java.lang.String recvTime;

    private java.lang.String content;

    public SmsRecvGroup() {
    }

    public SmsRecvGroup(
           java.lang.String mobile,
           java.lang.String recvNum,
           java.lang.String addNum,
           java.lang.String recvTime,
           java.lang.String content) {
           this.mobile = mobile;
           this.recvNum = recvNum;
           this.addNum = addNum;
           this.recvTime = recvTime;
           this.content = content;
    }


    /**
     * Gets the mobile value for this SmsRecvGroup.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this SmsRecvGroup.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the recvNum value for this SmsRecvGroup.
     * 
     * @return recvNum
     */
    public java.lang.String getRecvNum() {
        return recvNum;
    }


    /**
     * Sets the recvNum value for this SmsRecvGroup.
     * 
     * @param recvNum
     */
    public void setRecvNum(java.lang.String recvNum) {
        this.recvNum = recvNum;
    }


    /**
     * Gets the addNum value for this SmsRecvGroup.
     * 
     * @return addNum
     */
    public java.lang.String getAddNum() {
        return addNum;
    }


    /**
     * Sets the addNum value for this SmsRecvGroup.
     * 
     * @param addNum
     */
    public void setAddNum(java.lang.String addNum) {
        this.addNum = addNum;
    }


    /**
     * Gets the recvTime value for this SmsRecvGroup.
     * 
     * @return recvTime
     */
    public java.lang.String getRecvTime() {
        return recvTime;
    }


    /**
     * Sets the recvTime value for this SmsRecvGroup.
     * 
     * @param recvTime
     */
    public void setRecvTime(java.lang.String recvTime) {
        this.recvTime = recvTime;
    }


    /**
     * Gets the content value for this SmsRecvGroup.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this SmsRecvGroup.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsRecvGroup)) return false;
        SmsRecvGroup other = (SmsRecvGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.recvNum==null && other.getRecvNum()==null) || 
             (this.recvNum!=null &&
              this.recvNum.equals(other.getRecvNum()))) &&
            ((this.addNum==null && other.getAddNum()==null) || 
             (this.addNum!=null &&
              this.addNum.equals(other.getAddNum()))) &&
            ((this.recvTime==null && other.getRecvTime()==null) || 
             (this.recvTime!=null &&
              this.recvTime.equals(other.getRecvTime()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getRecvNum() != null) {
            _hashCode += getRecvNum().hashCode();
        }
        if (getAddNum() != null) {
            _hashCode += getAddNum().hashCode();
        }
        if (getRecvTime() != null) {
            _hashCode += getRecvTime().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SmsRecvGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "SmsRecvGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recvNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RecvNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AddNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recvTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RecvTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
