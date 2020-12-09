package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.market.ItemAppraiseImg;


import java.util.List;

/**
 * <p>
 * 商品评价图片
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:35 2020/3/24
 **/
public interface ItemAppraiseImgService {

    /**
     * <p>
     * 新增图片列表
     * </p>
     *
     * @param appraiseImgList 图片列表
     * @return int
     * @author LiuXiangLin
     * @date 9:35 2020/3/24
     **/
    int save(List<ItemAppraiseImg> appraiseImgList);

    /**
     * <p>
     * 通过评价评价编号删除所有的评价图片
     * </p>
     *
     * @param itemAppraiseNo 评价编号
     * @return int
     * @author LiuXiangLin
     * @date 10:12 2020/3/24
     **/
    int deleteByAppraiseNo(int itemAppraiseNo);
}
