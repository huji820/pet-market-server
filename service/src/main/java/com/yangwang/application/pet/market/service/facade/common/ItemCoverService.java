package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemCover;

import java.util.List;

/**
 * <p>
 * 商品图片
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemCoverService
 * @date 2020/4/9 10:33
 **/
public interface ItemCoverService {
    /**
     * <p>
     * 新增列表
     * </p>
     *
     * @param itemCoverList 商品图片列表
     * @return int
     * @author LiuXiangLin
     * @date 10:34 2020/4/9
     **/
    int saveList(List<ItemCover> itemCoverList);

    /**
     * <p>
     * 通过商品编号删除数据
     * </p>
     *
     * @param itemNo 商品编号
     * @return int
     * @author LiuXiangLin
     * @date 10:34 2020/4/9
     **/
    int deleteByItemNo(int itemNo);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param itemCoverList 图片列表
     * @param item 商品对象
     * @return int
     * @author LiuXiangLin
     * @date 10:42 2020/4/9
     **/
    int update(List<ItemCover> itemCoverList, Item item);
}
