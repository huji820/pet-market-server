package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.service.ServicePrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务价格
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:19 2020/4/2
 **/
@Mapper
public interface ServicePriceMapper {

    /**
     * 批量插入价格段
     * @param prices
     * @return
     */
    int insertServicePrice(@Param("prices") List<ServicePrice> prices);

    /**
     * 删除服务价格
     * @param serviceId
     */
    void deleteServicePrice(long serviceId);

    /**
     * 获取服务价格
     * @param petSortNo
     * @param serviceId
     * @param hairLength
     * @param weight
     * @param age
     * @return
     */
    ServicePrice getServicePrice(@Param("petSortNo") Integer petSortNo, @Param("serviceId") Integer serviceId, @Param("hairLength") Integer hairLength, @Param("weight") Integer weight, @Param("age") Integer age);
}
