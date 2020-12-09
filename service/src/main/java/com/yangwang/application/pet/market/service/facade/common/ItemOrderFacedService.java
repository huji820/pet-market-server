package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.vo.ItemOrderVo;
import com.yangwang.application.pet.market.model.vo.OrderPriceVo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 * 商品订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderFacedService
 * @date 2020/3/31 10:37
 **/
public interface ItemOrderFacedService {
    /**
     * <p>
     * 新增订单
     * </p>
     *
     * @param itemOrderVo 宠物订单vo
     * @return int
     * @author LiuXiangLin
     * @date 10:40 2020/3/31
     **/
    long save(ItemOrderVo itemOrderVo);

    /**
     * <p>
     * 获取订单价格
     * </p>
     *
     * @param itemOrderVo 订单vo对象
     * @return com.yangwang.application.pet.market.model.vo.OrderPriceVo
     * @author LiuXiangLin
     * @date 10:41 2020/3/31
     **/
    OrderPriceVo getPrice(ItemOrderVo itemOrderVo);

    /**
     * <p>
     * 获取支付参数
     * </p>
     *
     * @param orderNo   订单编号
     * @param ipAddress 用户ip地址
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author LiuXiangLin
     * @date 10:43 2020/3/31
     **/
    Map<String, String> getPayParam(String orderNo, String ipAddress) throws Exception;

    /**
     * <p>
     * 订单回调
     * </p>
     *
     * @param orderNo 订单编号
     * @return int
     * @author LiuXiangLin
     * @date 14:07 2020/4/1
     **/
    int payCallBack(String orderNo) throws Exception;

    /**
     * <p>
     * 取消未支付的订单
     * </p>
     *
     * @param
     * @return void
     * @author LiuXiangLin
     * @date 11:41 2020/4/26
     **/
    void cancelUnpaidOrder();

    /**
     * <p>
     * 签收订单
     * </p>
     *
     * @param orderNo 订单编号
     * @return int
     * @author LiuXiangLin
     * @date 11:18 2020/4/30
     **/
    int signForOrder(String orderNo);

    /**
     * <p>
     * 订单发货
     * </p>
     *
     * @param orderNo 订单编号
     * @param wayBill 运单号
     * @param expressCompany 快递公司
     * @return int
     * @author LiuXiangLin
     * @date 16:13 2020/4/30
     **/
    int deliverForOrder(String orderNo, String wayBill, String expressCompany);


    /**
     * 添加支付凭证
     *
     * @param orderNo
     * @param paymentVoucher
     * @return int
     * @author HuZhengYu
     * @date 18:09 2020/9/28
     */
    int uploadPaymentVoucher(String orderNo, String paymentVoucher);

    /**
     * 修改订单价格
     *
     * @param orderNo
     * @param price
     * @return int
     * @author HuZhengYu
     * @date 15:28 2020/9/30
     */
    int updateOrderPrice(String orderNo, BigDecimal price);
}
