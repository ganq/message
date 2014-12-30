package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class TextFileFilter extends FileFilter{
	String txt;   
    String smil;   
  
    public TextFileFilter(){}
    public TextFileFilter(String ext) {   
        String[] temp = ext.split(";");   
        this.txt = temp[0];
        this.smil = temp[1];   
    }

    public boolean accept(File file)   
    {
        if (file.isDirectory())   
        {
            return true;   
        }
        String fileName = file.getName();   
        int index = fileName.lastIndexOf('.');   
        if (index > 0 && index < fileName.length() - 1)   
        {
            String extension = fileName.substring(index + 1).toLowerCase();   
            // ����ץ�����ļ���չ���������������Ҫ��ʾ����չ��(������extֵ),�򷵻�true,��ʾ�����ļ���ʾ����   
            if (extension.equals(txt) || extension.equals(smil))   
                return true;   
        }
        return false;   
    } 
    // ʵ��getDescription()����,���������ļ���˵���ַ�!!!   
    public String getDescription()   
    {
        if (txt.equals("txt") || smil.equals("smil"))   

            return "�ļ�(*txt;*.smil)";   
        return "";   
    }   
}
