package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.Business;

/**
 * <p>
 * 商家权重
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessPowerService
 * @date 2020/3/17 15:12
 **/
public interface BusinessPowerService {
    /**
     * <p>
     * 获取权重值
     * </p>
     *
     * @param business 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 15:12 2020/3/17
     **/
    int get(Business business);

    /**
     * <p>
     * 更新商家权重
     * </p>
     *
     * @param businessNo 商家编号
     * @param power      权重
     * @return int
     * @author LiuXiangLin
     * @date 15:13 2020/3/17
     **/
    int update(String businessNo, int power);
}
