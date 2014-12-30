package com.mysoft.b2b.bizsupport.scheduler.email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class EmailAttachment implements Serializable {

    /**
     * 附件名称
     */
    private String fileName;

    /**
     * 附件内容
     */
    private byte[] bs;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getBs() {
        return bs;
    }

    public void setBs(byte[] bs) {
        this.bs = bs;
    }

    public EmailAttachment() {
        super();
    }

    public EmailAttachment(String fileName, byte[] bs) {
        super();
        this.fileName = fileName;
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Email Attachment [fileName=" + fileName + "]";
    }

    public static void main(String[] args) {
        List<EmailAttachment> attList = new ArrayList<EmailAttachment>();
        attList.add(new EmailAttachment("abc.txt","123".getBytes()));
        attList.add(new EmailAttachment("abcd.txt","123".getBytes()));
        attList.add(new EmailAttachment("abcde.txt","123".getBytes()));
        
        System.out.println(attList.toString());
    }
}
