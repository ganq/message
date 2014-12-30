/**
 * SmsReportGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri;

public class SmsReportGroup  implements java.io.Serializable {
    private long smsID;

    private long status;

    private java.lang.String reportTime;

    private java.lang.String exStatus;

    public SmsReportGroup() {
    }

    public SmsReportGroup(
           long smsID,
           long status,
           java.lang.String reportTime,
           java.lang.String exStatus) {
           this.smsID = smsID;
           this.status = status;
           this.reportTime = reportTime;
           this.exStatus = exStatus;
    }


    /**
     * Gets the smsID value for this SmsReportGroup.
     * 
     * @return smsID
     */
    public long getSmsID() {
        return smsID;
    }


    /**
     * Sets the smsID value for this SmsReportGroup.
     * 
     * @param smsID
     */
    public void setSmsID(long smsID) {
        this.smsID = smsID;
    }


    /**
     * Gets the status value for this SmsReportGroup.
     * 
     * @return status
     */
    public long getStatus() {
        return status;
    }


    /**
     * Sets the status value for this SmsReportGroup.
     * 
     * @param status
     */
    public void setStatus(long status) {
        this.status = status;
    }


    /**
     * Gets the reportTime value for this SmsReportGroup.
     * 
     * @return reportTime
     */
    public java.lang.String getReportTime() {
        return reportTime;
    }


    /**
     * Sets the reportTime value for this SmsReportGroup.
     * 
     * @param reportTime
     */
    public void setReportTime(java.lang.String reportTime) {
        this.reportTime = reportTime;
    }


    /**
     * Gets the exStatus value for this SmsReportGroup.
     * 
     * @return exStatus
     */
    public java.lang.String getExStatus() {
        return exStatus;
    }


    /**
     * Sets the exStatus value for this SmsReportGroup.
     * 
     * @param exStatus
     */
    public void setExStatus(java.lang.String exStatus) {
        this.exStatus = exStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsReportGroup)) return false;
        SmsReportGroup other = (SmsReportGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.smsID == other.getSmsID() &&
            this.status == other.getStatus() &&
            ((this.reportTime==null && other.getReportTime()==null) || 
             (this.reportTime!=null &&
              this.reportTime.equals(other.getReportTime()))) &&
            ((this.exStatus==null && other.getExStatus()==null) || 
             (this.exStatus!=null &&
              this.exStatus.equals(other.getExStatus())));
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
        _hashCode += new Long(getSmsID()).hashCode();
        _hashCode += new Long(getStatus()).hashCode();
        if (getReportTime() != null) {
            _hashCode += getReportTime().hashCode();
        }
        if (getExStatus() != null) {
            _hashCode += getExStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SmsReportGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "SmsReportGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SmsID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ReportTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ExStatus"));
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
