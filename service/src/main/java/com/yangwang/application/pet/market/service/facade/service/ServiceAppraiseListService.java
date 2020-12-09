package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.params.QueryItemAppraiseListParam;
import com.yangwang.application.pet.market.model.service.QueryServiceAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.model.vo.ServiceAppraiseVo;

import java.util.List;

/**
 * <p>
 * 商品评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseListService
 * @date 2020/3/24 13:47
 **/
public interface ServiceAppraiseListService {
    /**
     * <p>
     * 通过查询参数获取评价列表
     * </p>
     *
     * @param queryServiceAppraiseListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ItemAppraiseVo>
     * @author LiuXiangLin
     * @date 13:50 2020/3/24
     **/
    List<ServiceAppraiseVo> list(QueryServiceAppraiseListParam queryServiceAppraiseListParam);
}
