package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryQueryListParam;

import java.util.List;

/**
 * <p>
 * 搜索
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryService
 * @date 2020/3/25 10:06
 **/
public interface QueryService<T> {
    /**
     * <p>
     * 通过关键字检索
     * </p>
     *
     * @param queryQueryListParam 关键字查询对象
     * @return java.util.List<T>
     * @author LiuXiangLin
     * @date 10:11 2020/3/25
     **/
    List<T> query(QueryQueryListParam queryQueryListParam);
}
