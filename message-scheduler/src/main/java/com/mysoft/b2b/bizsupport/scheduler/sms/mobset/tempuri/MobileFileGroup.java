/**
 * MobileFileGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri;

public class MobileFileGroup  implements java.io.Serializable {
    private long taskFileType;

    private java.lang.String taskFileID;

    public MobileFileGroup() {
    }

    public MobileFileGroup(
           long taskFileType,
           java.lang.String taskFileID) {
           this.taskFileType = taskFileType;
           this.taskFileID = taskFileID;
    }


    /**
     * Gets the taskFileType value for this MobileFileGroup.
     * 
     * @return taskFileType
     */
    public long getTaskFileType() {
        return taskFileType;
    }


    /**
     * Sets the taskFileType value for this MobileFileGroup.
     * 
     * @param taskFileType
     */
    public void setTaskFileType(long taskFileType) {
        this.taskFileType = taskFileType;
    }


    /**
     * Gets the taskFileID value for this MobileFileGroup.
     * 
     * @return taskFileID
     */
    public java.lang.String getTaskFileID() {
        return taskFileID;
    }


    /**
     * Sets the taskFileID value for this MobileFileGroup.
     * 
     * @param taskFileID
     */
    public void setTaskFileID(java.lang.String taskFileID) {
        this.taskFileID = taskFileID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MobileFileGroup)) return false;
        MobileFileGroup other = (MobileFileGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.taskFileType == other.getTaskFileType() &&
            ((this.taskFileID==null && other.getTaskFileID()==null) || 
             (this.taskFileID!=null &&
              this.taskFileID.equals(other.getTaskFileID())));
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
        _hashCode += new Long(getTaskFileType()).hashCode();
        if (getTaskFileID() != null) {
            _hashCode += getTaskFileID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MobileFileGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "MobileFileGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskFileType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TaskFileType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskFileID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TaskFileID"));
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
