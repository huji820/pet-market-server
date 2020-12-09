package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.service.ServicePrice;

import java.util.List;

public interface ServicePriceService {

    /**
     * 批量插入价格段
     * @param prices
     * @return
     */
    int insertServicePrice(List<ServicePrice> prices);

    /**
     * 删除服务价格
     * @param serviceId
     */
    void deleteServicePrice(long serviceId);

    /**
     * 获取服务价格
     * @param petGenreNo
     * @param serviceId
     * @param hairLength
     * @param weight
     * @param age
     * @return
     */
    ServicePrice getServicePrice(Integer petGenreNo, Integer serviceId, Integer hairLength, Integer weight, Integer age);
}
