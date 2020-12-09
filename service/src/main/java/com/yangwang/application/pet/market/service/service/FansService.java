package com.yangwang.application.pet.market.service.service;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFansListParam;

import java.util.List;

/**
 * <p>
 * 粉丝
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FansService
 * @date 2020/3/25 9:42
 **/
public interface FansService {
    /**
     * <p>
     * 通过条件查询粉丝列表
     * </p>
     *
     * @param queryFansListParam 粉丝查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.business.Follow>
     * @author LiuXiangLin
     * @date 9:42 2020/3/25
     **/
    List<Follow> listByParam(QueryFansListParam queryFansListParam);
}
