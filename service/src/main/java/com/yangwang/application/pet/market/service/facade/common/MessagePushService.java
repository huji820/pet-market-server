package com.yangwang.application.pet.market.service.facade.common;

public interface MessagePushService {

    /**
     *
     *
     * @param commodityNo
     * @param messageType
     * @return void
     * @author yang hituzi
     * @date 15:22 2020/4/13
     */
    void messagePush(String commodityNo, Integer messageType);

    /**
     * 推送站内信商家
     * @param commodityNo
     * @param messageType
     */
    void messagePushBusiness(String commodityNo, Integer messageType,String orderNo);
}
