package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.ItemGroupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团购商品
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemGrouponMapper
 * @date 2020/4/8 17:55
 **/
public interface ItemGrouponMapper {
    /**
     * <p>
     * 新增一个列表
     * </p>
     *
     * @param itemGrouponList 团购商品列表
     * @return int
     * @author LiuXiangLin
     * @date 17:55 2020/4/8
     **/
    int saveList(@Param("itemGrouponList") List<ItemGroupon> itemGrouponList);

    /**
     * <p>
     * 通过商品主键删除数据
     * </p>
     *
     * @param itemNo 商品主键
     * @return int
     * @author LiuXiangLin
     * @date 17:57 2020/4/8
     **/
    int deleteByItemNo(@Param("itemNo") int itemNo);
}
