package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.market.PetAppraiseImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评价图片
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:45 2020/3/23
 **/
public interface PetAppraiseImgMapper {
    /**
     * <p>
     * 新增数据
     * </p>
     *
     * @param petAppraiseImgList 图片列表
     * @return int
     * @author LiuXiangLin
     * @date 16:46 2020/3/23
     **/
    int saveList(@Param("petAppraiseImgList") List<PetAppraiseImg> petAppraiseImgList);

    /**
     * <p>
     * 通过评价主键删除数据
     * </p>
     *
     * @param petAppraiseNo 评价主键
     * @return int
     * @author LiuXiangLin
     * @date 16:48 2020/3/23
     **/
    int delete(@Param("petAppraiseNo") int petAppraiseNo);
}
