package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemGroupon;

import java.util.List;

/**
 * <p>
 * 商品组合商品
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemGrouponService
 * @date 2020/4/9 10:03
 **/
public interface ItemGrouponService {
    /**
     * <p>
     * 新增列表
     * </p>
     *
     * @param itemGrouponList 组合商品列表
     * @return int
     * @author LiuXiangLin
     * @date 10:03 2020/4/9
     **/
    int saveList(List<ItemGroupon> itemGrouponList);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param itemGroupons 组合商品列表
     * @param item         商品对象
     * @return int
     * @author LiuXiangLin
     * @date 10:07 2020/4/9
     **/
    int update(List<ItemGroupon> itemGroupons, Item item);
}
