package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.CustomerMessage;
import com.yangwang.application.pet.market.model.params.QueryMessageParam;

import java.util.List;

public interface  MessageService {

    /**
     *
     * 新增站内信消息
     * @param customerMessage
     * @return int
     * @author yang hituzi
     * @date 11:57 2020/4/13
     */
    int insertMessage(CustomerMessage customerMessage);

    /**
     *
     * 更新站内信消息状态
     * @param messageNo
     * @return int
     * @author yang hituzi
     * @date 11:58 2020/4/13
     */
    int updateMessage(Integer messageNo);

    /**
     *
     * 根据站内信编号获取站内信消息
     * @param messageNo
     * @return com.yangwang.application.pet.market.model.common.CustomerMessage
     * @author yang hituzi
     * @date 14:09 2020/4/13
     */
    CustomerMessage getMessageByNo(Integer messageNo);

    /**
     *
     * 通过businessNo查询用户所有站内信消息
     * @param businessNo
     * @return java.util.List<com.yangwang.application.pet.market.model.common.CustomerMessage>
     * @author yang hituzi
     * @date 12:03 2020/4/13
     */
    List<CustomerMessage> listMessageByBusinessNo(String businessNo,Integer offset,Integer limit);

    /**
     *
     * 获取关注该商家/商品/宠物 的用户的手机号列表
     * @param keyNo
     * @param queryType
     * @return java.util.List<java.lang.String>
     * @author yang hituzi
     * @date 17:19 2020/4/13
     */
    List<String> listFollowBusinessNo(String keyNo, Integer queryType);

    /**
     * 获取指定时间之后的站内信
     * @param phone
     * @param lastGetTime
     * @return
     */
    List<CustomerMessage> listMessageByUpdateTimeAndBusinessNo(String phone,String lastGetTime);
    /**
     * 获取指定时间之后的站内信数量
     * @param phone
     * @param lastGetTime
     * @return
     */
    int countMsgByUpdateTimeAndBusinessNo(String phone,String lastGetTime);
}
