package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class AudoiFileFilter extends FileFilter{
	String mid;   
    String midi;   
    String amr;
    
    public AudoiFileFilter(){}
    public AudoiFileFilter(String ext) {
        String[] temp = ext.split(";");   
        this.mid = temp[0];
        this.midi = temp[1];
        this.amr = temp[2];
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
            if (extension.equals(mid) || extension.equals(midi) || extension.equals(amr))   
                return true;   
        }
        return false;   
    }
    // ʵ��getDescription()����,���������ļ���˵���ַ�!!!   
    public String getDescription()   
    {
        if (mid.equals("mid") || midi.equals("midi") || amr.equals("amr"))   

            return "�ļ�(*mid;*.midi;*.amr)";   
        return "";   
    }
}
