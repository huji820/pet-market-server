package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.params.QueryItemAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;

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
public interface ItemAppraiseListService {
    /**
     * <p>
     * 通过查询参数获取评价列表
     * </p>
     *
     * @param queryItemAppraiseListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ItemAppraiseVo>
     * @author LiuXiangLin
     * @date 13:50 2020/3/24
     **/
    List<ItemAppraiseVo> list(QueryItemAppraiseListParam queryItemAppraiseListParam);
}
