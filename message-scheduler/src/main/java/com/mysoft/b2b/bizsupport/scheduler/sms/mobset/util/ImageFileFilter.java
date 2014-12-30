package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageFileFilter extends FileFilter{
	String jpg;   
    String gif;   
  
    public ImageFileFilter(){}
    public ImageFileFilter(String ext) {   
        String[] temp = ext.split(";");   
        this.jpg = temp[0];   
        this.gif = temp[1];   
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
            if (extension.equals(jpg) || extension.equals(gif))   
                return true;   
        }   
        return false;   
    } 
    // ʵ��getDescription()����,���������ļ���˵���ַ�!!!   
    public String getDescription()   
    {
        if (jpg.equals("jpg") || gif.equals("gif"))   

            return "�ļ�(*jpg;*.gif)";   
        return "";   
    }   
}
