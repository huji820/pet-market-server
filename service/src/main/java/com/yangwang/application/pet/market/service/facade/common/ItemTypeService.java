package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.ItemType;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;

import java.util.List;

/**
 * <p>
 * 商品类型
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemTypeService
 * @date 2020/3/22 10:52
 **/
public interface ItemTypeService {
    /**
     * <p>
     * 通过参数查询列表
     * </p>
     *
     * @param pagingQueryParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemType>
     * @author LiuXiangLin
     * @date 10:52 2020/3/22
     **/
    List<ItemType> listByParam(PagingQueryParam pagingQueryParam);
}
