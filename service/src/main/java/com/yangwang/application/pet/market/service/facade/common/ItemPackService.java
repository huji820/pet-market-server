package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.ItemPack;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;

import java.util.List;

/**
 * <p>
 * 宠物套餐
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:16 2020/3/22
 **/
public interface ItemPackService {
    /**
     * <p>
     * 查询所有
     * </p>
     *
     * @param pagingQueryParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemPack>
     * @author LiuXiangLin
     * @date 10:16 2020/3/22
     **/
    List<ItemPack> listAll(PagingQueryParam pagingQueryParam);
}
