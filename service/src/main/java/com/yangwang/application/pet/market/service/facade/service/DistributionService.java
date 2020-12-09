package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.business.Distribution;

import java.util.List;

/**
 * <p>
 * 分销
 * </p>
 *
 * @author LiuXiangLin
 * @date 15:12 2020/4/28
 **/
public interface DistributionService {

    /**
     * 获取分销列表
     * @param businessNo
     * @param startDate
     * @param endDate
     * @param offset
     * @param limit
     * @return
     */
    List<Distribution> listDistribution(String businessNo, String startDate, String endDate, int offset, int limit);

    /**
     * <p>
     * 新增一条流水
     * </p>
     *
     * @param distribution 分销对象
     * @return int
     * @author LiuXiangLin
     * @date 10:24 2020/4/26
     **/
    int save(Distribution distribution);
}
