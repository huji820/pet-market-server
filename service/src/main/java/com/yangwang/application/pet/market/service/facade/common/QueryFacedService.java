package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.vo.QueryVo;

/**
 * <p>
 * 搜索查询
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryFacedService
 * @date 2020/3/25 10:35
 **/
public interface QueryFacedService {
    /**
     * <p>
     * 搜索查询
     * </p>
     *
     * @param keyWord 关键字
     * @return com.yangwang.application.pet.market.model.vo.QueryVo
     * @author LiuXiangLin
     * @date 10:36 2020/3/25
     **/
    QueryVo query(String keyWord);
}
