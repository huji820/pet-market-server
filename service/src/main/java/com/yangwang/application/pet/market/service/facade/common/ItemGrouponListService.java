package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;

import java.util.List;

/**
 * <p>
 * 团购商品列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemGrouponListService
 * @date 2020/5/26 10:16
 **/
public interface ItemGrouponListService {
    /**
     * <p>
     * 通过参数查询商品团购列表
     * </p>
     *
     * @param queryItemListParam 商品团购列表
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ItemVo>
     * @author LiuXiangLin
     * @date 10:17 2020/5/26
     **/
    List<ItemVo> listByParam(QueryItemListParam queryItemListParam);
}
