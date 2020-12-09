package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.common.CustomerMessage;
import com.yangwang.application.pet.market.model.params.QueryMessageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {

    /**
     * 
     * 新增站内信消息
     * @param customerMessage
     * @return int
     * @author yang hituzi
     * @date 11:14 2020/4/13
     */
    int insertMessage(@Param("customerMessage") CustomerMessage customerMessage);

    /**
     *
     * 更新站内信消息状态
     * @param messageNo
     * @param updateTime
     * @return int
     * @author yang hituzi
     * @date 11:20 2020/4/13
     */
    int updateMessage(@Param("messageNo") Integer messageNo,
                      @Param("updateTime") String updateTime);

    /**
     *
     * 根据站内信编号获取站内信消息
     * @param messageNo
     * @return com.yangwang.application.pet.market.model.common.CustomerMessage
     * @author yang hituzi
     * @date 11:48 2020/4/13
     */
    CustomerMessage getMessageByNo(@Param("messageNo") Integer messageNo);

    /**
     *
     * 通过BusinessNo获取用户所有的站内信
     * @param businessNo
     * @param start
     * @param limit
     * @return java.util.List<com.yangwang.application.pet.market.model.common.CustomerMessage>
     * @author yang hituzi
     * @date 14:17 2020/4/13
     */
    List<CustomerMessage> listMessageByBusinessNo(@Param("businessNo")String businessNo,@Param("start")int start,@Param("limit")int limit);

    /**
     *
     * 获取关注该商家/商品/宠物 的用户的手机号列表
     * @param keyNo
     * @param query
     * @return java.util.List<java.lang.String>
     * @author yang hituzi
     * @date 17:24 2020/4/13
     */
    List<String> listFollowBusinessNo(@Param("keyNo") String keyNo,
                                 @Param("queryType") Integer query);

    /**
     * 获取指定时间之后的站内信消息
     * @param businessNo
     * @param lastGetTime
     * @return
     */
    List<CustomerMessage> listMessageByUpdateTimeAndBusinessNo(@Param("businessNo")String businessNo,
                                                          @Param("lastGetTime")String lastGetTime);
    /**
     * 获取指定时间之后的站内信消息数量
     * @param businessNo
     * @param lastGetTime
     * @return
     */
    int countMsgByUpdateTimeAndBusinessNo(@Param("businessNo")String businessNo,
                                                          @Param("lastGetTime")String lastGetTime);
}
