package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.ItemCover;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家图片
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemCoverMapper
 * @date 2020/4/9 10:20
 **/
public interface ItemCoverMapper {
    /**
     * <p>
     * 新增一个商家图片列表
     * </p>
     *
     * @param itemCoverList 商家图片
     * @return int
     * @author LiuXiangLin
     * @date 10:21 2020/4/9
     **/
    int saveList(@Param("itemCoverList") List<ItemCover> itemCoverList);

    /**
     * <p>
     * 通过商品主键删除数据
     * </p>
     *
     * @param itemNo 商品主键
     * @return int
     * @author LiuXiangLin
     * @date 10:22 2020/4/9
     **/
    int deleteByItemNo(@Param("itemNo") int itemNo);
}
