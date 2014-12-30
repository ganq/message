package com.mysoft.b2b.bizsupport.scheduler.sms.util;

import java.util.Date;
import java.util.List;

/**
 * 
 * chengp: Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     Version       Date        Changes
 * chengp    1.0           2014年8月15日     Created
 *
 * </pre>
 * @since 8.
 */
public class ReplyResultBean {

    private int result;

    private Date confimDate;

    private List<ReplyResult> replyList;

    private String replyId;

    public ReplyResultBean() {

    }

    public ReplyResultBean(int result, String replyId) {
        this.replyId = replyId;
        this.result = result;
    }

    public ReplyResultBean(int result, String replyId, List<ReplyResult> replyList) {
        this.replyId = replyId;
        this.result = result;
        this.replyList = replyList;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getConfimDate() {
        return confimDate;
    }

    public void setConfimDate(Date confimDate) {
        this.confimDate = confimDate;
    }

    public List<ReplyResult> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<ReplyResult> replyList) {
        this.replyList = replyList;
    }

    public ReplyResult createReplyResult() {
        return new ReplyResult();
    }

    public ReplyResult createReplyResult(String callIn, String phone, String message, Date date) {
        return new ReplyResult(callIn, phone, message, date, 0);
    }

    public ReplyResult createReplyResult(String callIn, String phone, String message, Date date, long systemId) {
        return new ReplyResult(callIn, phone, message, date, systemId);
    }

    public class ReplyResult {

        private String callIn;

        private String phone;

        private String message;

        private Date date;

        private long systemId;

        public ReplyResult() {

        }

        public ReplyResult(String callIn, String phone, String message, Date date, long systemId) {
            this.callIn = callIn;
            this.phone = phone;
            this.message = message;
            this.date = date;
            this.systemId = systemId;
        }

        public String getCallIn() {
            return callIn;
        }

        public void setCallIn(String callIn) {
            this.callIn = callIn;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public long getSystemId() {
            return systemId;
        }

        public void setSystemId(long systemId) {
            this.systemId = systemId;
        }
    }
}
