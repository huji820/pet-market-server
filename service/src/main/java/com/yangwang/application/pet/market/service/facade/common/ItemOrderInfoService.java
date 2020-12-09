package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.market.ItemOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  商品订单详情信息service
 * </p>
 *
 * @Author zhouxiaojian
 * @Date 2020/9/4 11:38
 * @Version 1.0
 */
public interface ItemOrderInfoService {

    /**
     * @Description: 保存商品订单信息
     * @Author: zxj
     * @Date: 2020/9/4 11:41
     * @param itemOrderInfo: 商品订单信息model
     * @return: int
     **/
    int save(ItemOrderInfo itemOrderInfo);

    /**
     * @Description: 通过订单编号获取所有相关商品订单详情信息
     * @Author: zxj
     * @Date: 2020/9/4 11:42
     * @param orderNo:
     * @return: java.util.List<com.yangwang.application.pet.market.model.market.ItemOrderInfo>
     **/
    List<ItemOrderInfo> listByOrderNo(String orderNo);

    /**
     * @Description: 通过订单详情信息主键获取商品订单详情信息
     * @Author: zxj
     * @Date: 2020/9/4 11:44
     * @param orderInfoNo:
     * @return: com.yangwang.application.pet.market.model.market.ItemOrderInfo
     **/
    ItemOrderInfo getByOrderInfoNo(String orderInfoNo);
}
