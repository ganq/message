/**
 * MmsRecvFileGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri;

public class MmsRecvFileGroup  implements java.io.Serializable {
    private java.lang.String fileName;

    private java.lang.String fileType;

    private java.lang.String fileID;

    private java.lang.String fileLocation;

    private byte[] fileData;

    public MmsRecvFileGroup() {
    }

    public MmsRecvFileGroup(
           java.lang.String fileName,
           java.lang.String fileType,
           java.lang.String fileID,
           java.lang.String fileLocation,
           byte[] fileData) {
           this.fileName = fileName;
           this.fileType = fileType;
           this.fileID = fileID;
           this.fileLocation = fileLocation;
           this.fileData = fileData;
    }


    /**
     * Gets the fileName value for this MmsRecvFileGroup.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this MmsRecvFileGroup.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the fileType value for this MmsRecvFileGroup.
     * 
     * @return fileType
     */
    public java.lang.String getFileType() {
        return fileType;
    }


    /**
     * Sets the fileType value for this MmsRecvFileGroup.
     * 
     * @param fileType
     */
    public void setFileType(java.lang.String fileType) {
        this.fileType = fileType;
    }


    /**
     * Gets the fileID value for this MmsRecvFileGroup.
     * 
     * @return fileID
     */
    public java.lang.String getFileID() {
        return fileID;
    }


    /**
     * Sets the fileID value for this MmsRecvFileGroup.
     * 
     * @param fileID
     */
    public void setFileID(java.lang.String fileID) {
        this.fileID = fileID;
    }


    /**
     * Gets the fileLocation value for this MmsRecvFileGroup.
     * 
     * @return fileLocation
     */
    public java.lang.String getFileLocation() {
        return fileLocation;
    }


    /**
     * Sets the fileLocation value for this MmsRecvFileGroup.
     * 
     * @param fileLocation
     */
    public void setFileLocation(java.lang.String fileLocation) {
        this.fileLocation = fileLocation;
    }


    /**
     * Gets the fileData value for this MmsRecvFileGroup.
     * 
     * @return fileData
     */
    public byte[] getFileData() {
        return fileData;
    }


    /**
     * Sets the fileData value for this MmsRecvFileGroup.
     * 
     * @param fileData
     */
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MmsRecvFileGroup)) return false;
        MmsRecvFileGroup other = (MmsRecvFileGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.fileType==null && other.getFileType()==null) || 
             (this.fileType!=null &&
              this.fileType.equals(other.getFileType()))) &&
            ((this.fileID==null && other.getFileID()==null) || 
             (this.fileID!=null &&
              this.fileID.equals(other.getFileID()))) &&
            ((this.fileLocation==null && other.getFileLocation()==null) || 
             (this.fileLocation!=null &&
              this.fileLocation.equals(other.getFileLocation()))) &&
            ((this.fileData==null && other.getFileData()==null) || 
             (this.fileData!=null &&
              java.util.Arrays.equals(this.fileData, other.getFileData())));
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
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFileType() != null) {
            _hashCode += getFileType().hashCode();
        }
        if (getFileID() != null) {
            _hashCode += getFileID().hashCode();
        }
        if (getFileLocation() != null) {
            _hashCode += getFileLocation().hashCode();
        }
        if (getFileData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MmsRecvFileGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "MmsRecvFileGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FileType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FileID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FileLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FileData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
