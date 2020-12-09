package com.yangwang.application.pet.market.service.facade.customer;


import com.yangwang.application.pet.market.model.market.PetAppraiseImg;

import java.util.List;

/**
 * <p>
 * 宠物评价图片
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:56 2020/3/23
 **/
public interface PetAppraiseImgService {
    /**
     * <p>
     * 新增列表
     * </p>
     *
     * @param petAppraiseImgList 图片列表
     * @return int
     * @author LiuXiangLin
     * @date 16:57 2020/3/23
     **/
    int saveList(List<PetAppraiseImg> petAppraiseImgList);

    /**
     * <p>
     * 通过评价主键删除图片
     * </p>
     *
     * @param petAppraiseNo 评价主键
     * @return int
     * @author LiuXiangLin
     * @date 16:57 2020/3/23
     **/
    int delete(int petAppraiseNo);
}
