package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.market.ItemAppraiseImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物评价图片列表
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:30 2020/3/24
 **/
@Mapper
public interface ItemAppraiseImgMapper {
    /**
     * <p>
     * 保存列表
     * </p>
     *
     * @param itemAppraiseImgList 宠物评价图片列表
     * @return int
     * @author LiuXiangLin
     * @date 9:29 2020/3/24
     **/
    int saveList(@Param("itemAppraiseImgList") List<ItemAppraiseImg> itemAppraiseImgList);

    /**
     * <p>
     * 通过评价编号删除评价图片
     * </p>
     *
     * @param appraiseNo 评价编号
     * @return int
     * @author LiuXiangLin
     * @date 10:15 2020/3/24
     **/
    int deleteByAppraiseNo(@Param("appraiseNo") int appraiseNo);
}
