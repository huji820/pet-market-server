package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.market.ServiceOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceOrderMapper {

    int insertOrder(@Param("order") ServiceOrder order);


    /**
     * 获取服务订单
     * @param billNo
     * @return
     */
    ServiceOrder getServiceOrder(String billNo);

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
     * 修改订单支付状态
     * @param serviceOrder 服务订单
     * @return
     */
    int updateServicePayment(ServiceOrder serviceOrder);

    /**
     * 
     * 核销服务订单
     * @param orderNo
     * @return int
     * @author yang hituzi
     * @date 9:48 2020/4/2
     */
    int updateVerifyState(@Param("orderNo") String orderNo);

    /**
     * <p>
     * 修改订单状态
     * </p>
     *
     * @param orderNo 订单编号
     * @param payState 支付状态
     * @return int
     * @author LiuXiangLin
     * @date 10:52 2020/6/18
     **/
    int updatePayState(@Param("orderNo")String orderNo,@Param("payState")int payState);

}
