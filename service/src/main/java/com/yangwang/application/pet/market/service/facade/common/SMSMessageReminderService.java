package com.yangwang.application.pet.market.service.facade.common;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

/**
 * @program: trunk
 * @description: 短信消息提醒
 * @author: lsy
 * @create: 2019-12-06 14:28
 **/
public interface SMSMessageReminderService {
    String sendDeliveryMessageReminder(String phone,String name,String waybill) throws Exception;

    /**
     * 发送商品售出消息提醒商家
     * @param phone
     * @return
     */
    void sendMsgToBusiness(String phone) throws Exception;
}
