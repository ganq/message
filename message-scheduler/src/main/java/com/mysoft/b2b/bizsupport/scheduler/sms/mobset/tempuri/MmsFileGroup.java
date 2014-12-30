/**
 * MmsFileGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri;

public class MmsFileGroup  implements java.io.Serializable {
    private long playTime;

    private java.lang.String image_FileName;

    private byte[] image_FileData;

    private java.lang.String text_FileName;

    private java.lang.String text_Content;

    private java.lang.String audio_FileName;

    private byte[] audio_FileData;

    public MmsFileGroup() {
    }

    public MmsFileGroup(
           long playTime,
           java.lang.String image_FileName,
           byte[] image_FileData,
           java.lang.String text_FileName,
           java.lang.String text_Content,
           java.lang.String audio_FileName,
           byte[] audio_FileData) {
           this.playTime = playTime;
           this.image_FileName = image_FileName;
           this.image_FileData = image_FileData;
           this.text_FileName = text_FileName;
           this.text_Content = text_Content;
           this.audio_FileName = audio_FileName;
           this.audio_FileData = audio_FileData;
    }


    /**
     * Gets the playTime value for this MmsFileGroup.
     * 
     * @return playTime
     */
    public long getPlayTime() {
        return playTime;
    }


    /**
     * Sets the playTime value for this MmsFileGroup.
     * 
     * @param playTime
     */
    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }


    /**
     * Gets the image_FileName value for this MmsFileGroup.
     * 
     * @return image_FileName
     */
    public java.lang.String getImage_FileName() {
        return image_FileName;
    }


    /**
     * Sets the image_FileName value for this MmsFileGroup.
     * 
     * @param image_FileName
     */
    public void setImage_FileName(java.lang.String image_FileName) {
        this.image_FileName = image_FileName;
    }


    /**
     * Gets the image_FileData value for this MmsFileGroup.
     * 
     * @return image_FileData
     */
    public byte[] getImage_FileData() {
        return image_FileData;
    }


    /**
     * Sets the image_FileData value for this MmsFileGroup.
     * 
     * @param image_FileData
     */
    public void setImage_FileData(byte[] image_FileData) {
        this.image_FileData = image_FileData;
    }


    /**
     * Gets the text_FileName value for this MmsFileGroup.
     * 
     * @return text_FileName
     */
    public java.lang.String getText_FileName() {
        return text_FileName;
    }


    /**
     * Sets the text_FileName value for this MmsFileGroup.
     * 
     * @param text_FileName
     */
    public void setText_FileName(java.lang.String text_FileName) {
        this.text_FileName = text_FileName;
    }


    /**
     * Gets the text_Content value for this MmsFileGroup.
     * 
     * @return text_Content
     */
    public java.lang.String getText_Content() {
        return text_Content;
    }


    /**
     * Sets the text_Content value for this MmsFileGroup.
     * 
     * @param text_Content
     */
    public void setText_Content(java.lang.String text_Content) {
        this.text_Content = text_Content;
    }


    /**
     * Gets the audio_FileName value for this MmsFileGroup.
     * 
     * @return audio_FileName
     */
    public java.lang.String getAudio_FileName() {
        return audio_FileName;
    }


    /**
     * Sets the audio_FileName value for this MmsFileGroup.
     * 
     * @param audio_FileName
     */
    public void setAudio_FileName(java.lang.String audio_FileName) {
        this.audio_FileName = audio_FileName;
    }


    /**
     * Gets the audio_FileData value for this MmsFileGroup.
     * 
     * @return audio_FileData
     */
    public byte[] getAudio_FileData() {
        return audio_FileData;
    }


    /**
     * Sets the audio_FileData value for this MmsFileGroup.
     * 
     * @param audio_FileData
     */
    public void setAudio_FileData(byte[] audio_FileData) {
        this.audio_FileData = audio_FileData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MmsFileGroup)) return false;
        MmsFileGroup other = (MmsFileGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.playTime == other.getPlayTime() &&
            ((this.image_FileName==null && other.getImage_FileName()==null) || 
             (this.image_FileName!=null &&
              this.image_FileName.equals(other.getImage_FileName()))) &&
            ((this.image_FileData==null && other.getImage_FileData()==null) || 
             (this.image_FileData!=null &&
              java.util.Arrays.equals(this.image_FileData, other.getImage_FileData()))) &&
            ((this.text_FileName==null && other.getText_FileName()==null) || 
             (this.text_FileName!=null &&
              this.text_FileName.equals(other.getText_FileName()))) &&
            ((this.text_Content==null && other.getText_Content()==null) || 
             (this.text_Content!=null &&
              this.text_Content.equals(other.getText_Content()))) &&
            ((this.audio_FileName==null && other.getAudio_FileName()==null) || 
             (this.audio_FileName!=null &&
              this.audio_FileName.equals(other.getAudio_FileName()))) &&
            ((this.audio_FileData==null && other.getAudio_FileData()==null) || 
             (this.audio_FileData!=null &&
              java.util.Arrays.equals(this.audio_FileData, other.getAudio_FileData())));
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
        _hashCode += new Long(getPlayTime()).hashCode();
        if (getImage_FileName() != null) {
            _hashCode += getImage_FileName().hashCode();
        }
        if (getImage_FileData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImage_FileData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImage_FileData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getText_FileName() != null) {
            _hashCode += getText_FileName().hashCode();
        }
        if (getText_Content() != null) {
            _hashCode += getText_Content().hashCode();
        }
        if (getAudio_FileName() != null) {
            _hashCode += getAudio_FileName().hashCode();
        }
        if (getAudio_FileData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAudio_FileData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAudio_FileData(), i);
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
        new org.apache.axis.description.TypeDesc(MmsFileGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "MmsFileGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("playTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PlayTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("image_FileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Image_FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("image_FileData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Image_FileData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_FileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Text_FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_Content");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Text_Content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audio_FileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Audio_FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audio_FileData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Audio_FileData"));
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
