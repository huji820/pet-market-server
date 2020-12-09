package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.business.Business;

import java.util.List;

/**
 * <p>
 * 推荐商家
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className RecommendedBusinessService
 * @date 2020/3/17 11:21
 **/
public interface RecommendedBusinessService {
    /**
     * <p>
     * 获取数据
     * </p>
     *
     * @param offset 排除条数
     * @param limit  显示条数
     * @return java.util.List<com.yangwang.application.pet.market.model.business.Business>
     * @author LiuXiangLin
     * @date 11:21 2020/3/17
     **/
    List<Business> list(int offset, int limit);
}
