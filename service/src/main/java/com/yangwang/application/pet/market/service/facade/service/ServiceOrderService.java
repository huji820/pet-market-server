package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.market.ServiceOrder;

import java.util.List;
import java.util.Map;

public interface ServiceOrderService {

    /**
     * 插入订单
     *
     * @param order
     * @return
     */
    String insertOrder(ServiceOrder order,String ipAddress) throws Exception;

    /**
     * 获取服务订单
     * @param billNo
     * @return
     */
    ServiceOrder getServiceOrder(String billNo);

    /**
     * 修改订单支付状态
     * @param serviceOrder 服务订单
     * @return
     */
    int updateServicePayment(ServiceOrder serviceOrder);

    /**
     * 根据商家查询订单
     * @param businessNo
     * @param offset
     * @param limit
     * @return
     * @throws Exception
     */
    List<ServiceOrder> listOrdersByShop(String businessNo, int offset, int limit) throws Exception;

    /**
     * 根据用户查询订单
     * @param businessNo
     * @param offset
     * @param limit
     * @return
     * @throws Exception
     */
    List<ServiceOrder> listOrderByBusiness(String businessNo, int offset, int limit) throws Exception;

    /**
     *
     * 核销服务订单
     * @param orderNo
     * @return int
     * @author yang hituzi
     * @date 9:55 2020/4/2
     */
    int updateVerifyState(String orderNo);

    /**
     * <p>
     * 获取订单支付参数
     * </p>
     *
     * @param orderNo 订单编号
     * @param ipAddress ip地址
     * @return Map<String, String>
     * @author LiuXiangLin
     * @date 10:24 2020/6/18
     **/
    Map<String,String> getPayParam(String orderNo,String ipAddress) throws Exception;

    /**
     * <p>
     * 支付回调
     * </p>
     *
     * @param orderNo 订单编号
     * @return void
     * @author LiuXiangLin
     * @date 10:51 2020/6/18
     **/
    void payCallBack(String orderNo);
}
