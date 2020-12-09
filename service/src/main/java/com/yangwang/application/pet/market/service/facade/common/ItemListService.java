package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;

import java.util.List;

/**
 * <p>
 * 商品列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemListService
 * @date 2020/3/22 9:52
 **/
public interface ItemListService {
    /**
     * <p>
     * 通过查询参数获取列表
     * </p>
     *
     * @param queryItemListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ItemVo>
     * @author LiuXiangLin
     * @date 9:52 2020/3/22
     **/
    List<ItemVo> list(QueryItemListParam queryItemListParam);

    /**
     * 获取厂家商品
     * @param businessNo
     * @return
     */
    List<ItemVo> listManufactorItem(String businessNo);
}
