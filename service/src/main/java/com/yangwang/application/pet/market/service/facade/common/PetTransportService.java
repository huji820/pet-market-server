package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.market.PetOrderVo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 运输订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetTransportService
 * @date 2020/3/26 16:30
 **/
public interface PetTransportService {
    /**
     * <p>
     * 通过起始以及终点城市获取运输类型
     * </p>
     *
     * @param startCity 起始城市
     * @param endCity   终点城市
     * @return java.util.List<java.lang.Integer>
     * @author LiuXiangLin
     * @date 16:32 2020/3/26
     **/
    List<Integer> listTransportType(String startCity, String endCity);

    /**
     * <p>
     * 获取运输价格
     * </p>
     *
     * @param petOrderVo 订单Vo
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 17:06 2020/3/26
     **/
    BigDecimal getTransportPrice(PetOrderVo petOrderVo);

    /**
     * <p>
     * 新增运输订单
     * </p>
     *
     * @param petOrderVo 宠物订单
     * @return int
     * @author LiuXiangLin
     * @date 15:52 2020/3/28
     **/
    String saveTransportOrder(PetOrderVo petOrderVo);

    /**
     * <p>
     * 支付订单运输
     * </p>
     *
     * @param transportOrderNo 运输订单号
     * @return int
     * @author LiuXiangLin
     * @date 13:56 2020/4/26
     **/
    int payOrder(String transportOrderNo) throws IOException;

    /**
     * <p>
     * 查询运输订单详情
     * </p>
     *
     * @param orderNo 订单编号
     * @return java.lang.Object
     * @author LiuXiangLin
     * @date 14:28 2020/6/16
     **/
    Object getOrderState(String orderNo);

}
