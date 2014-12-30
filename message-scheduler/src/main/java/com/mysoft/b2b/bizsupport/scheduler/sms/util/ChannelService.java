package com.mysoft.b2b.bizsupport.scheduler.sms.util;

import java.util.List;

public interface ChannelService {

    /**
     * 发送短信接口
     * @param messageBean message实例对象
     * @return
     * @throws Exception
     */
    public void sendSMS(SMSMessageBean bean) throws Exception;

    /**
     * 处理短信发送回执报告
     * @param messageBean
     * @return
     * @throws Exception
     */
    public void dealReceipt() throws Exception;

    /**
     * 处理短信回复
     * @param messageBean
     * @return
     * @throws Exception
     */
    public void dealReply(SMSMessageBean bean) throws Exception;

    /**
     * 回复确认接口
     * @param bean
     * @return
     * @throws Exception
     */
    public void confimReplySMS() throws Exception;

    /**
     * 发送多条短信
     * @param list
     * @throws Exception
     */
    public void sendList(List<SMSMessageBean> list) throws Exception;

    /**
     * 修改短信通道密码
     * @param pwd
     * @throws Exception
     */
    public void updatePwd(SMSMessageBean bean, String pwd) throws Exception;

    /**
     * 重新发送
     * @param bean
     * @throws Exception
     */
    public void reSend(SMSMessageBean bean) throws Exception;

    /**
     * 剩余费用
     * @param bean
     * @return
     */
    public String getCost(SMSMessageBean bean);

}
