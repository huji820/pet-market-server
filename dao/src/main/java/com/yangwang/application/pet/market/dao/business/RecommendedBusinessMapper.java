package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 推荐商家
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className RecommendedBusinessMapper
 * @date 2020/3/17 11:24
 **/
public interface RecommendedBusinessMapper {
    /**
     * <p>
     * 查询推荐商家列表
     * </p>
     *
     * @param offset 排除条数
     * @param limit  显示条数
     * @return java.util.List<com.yangwang.application.pet.market.model.business.Business>
     * @author LiuXiangLin
     * @date 11:25 2020/3/17
     **/
    List<Business> list(@Param("offset") int offset, @Param("limit") int limit);
}
