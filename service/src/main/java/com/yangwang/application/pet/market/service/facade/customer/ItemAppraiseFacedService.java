package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;

/**
 * <p>
 * 商品评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseFacedService
 * @date 2020/3/24 9:39
 **/
public interface ItemAppraiseFacedService {
    /**
     * <p>
     * 添加商品评价
     * </p>
     *
     * @param itemAppraiseVo 商品评价Vo对象
     * @return int
     * @author LiuXiangLin
     * @date 9:39 2020/3/24
     **/
    int addAppraise(ItemAppraiseVo itemAppraiseVo);

    /**
     * <p>
     * 删除一条宠物评价
     * </p>
     *
     * @param itemAppraiseNo 宠物评价编号
     * @return int
     * @author LiuXiangLin
     * @date 9:40 2020/3/24
     **/
    int deleteAppraise(int itemAppraiseNo);
}
