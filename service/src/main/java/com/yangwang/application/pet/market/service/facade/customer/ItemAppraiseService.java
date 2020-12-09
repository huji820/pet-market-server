package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.market.ItemAppraise;


/**
 * <p>
 * 宠物评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:25 2020/3/24
 **/
public interface ItemAppraiseService {
    /**
     * <p>
     * 保存一条数据
     * </p>
     *
     * @param itemAppraise 宠物评价对象
     * @return int
     * @author LiuXiangLin
     * @date 9:26 2020/3/24
     **/
    int save(ItemAppraise itemAppraise);

    /**
     * <p>
     * 通过评价住家删除数据
     * </p>
     *
     * @param itemAppraiseNo 宠物评价
     * @return int
     * @author LiuXiangLin
     * @date 9:26 2020/3/24
     **/
    int delete(int itemAppraiseNo);

    /**
     * <p>
     * 通过评价对象查询评价
     * </p>
     *
     * @param itemAppraise 评价对象
     * @return com.yangwang.application.pet.market.model.market.ItemAppraise
     * @author LiuXiangLin
     * @date 9:42 2020/3/24
     **/
    ItemAppraise getByAppraise(ItemAppraise itemAppraise);

    /**
     * <p>
     * 通过评价主键查询评价
     * </p>
     *
     * @param itemAppraiseNo 评价主键
     * @return com.yangwang.application.pet.market.model.market.ItemAppraise
     * @author LiuXiangLin
     * @date 9:48 2020/3/24
     **/
    ItemAppraise get(int itemAppraiseNo);

    /**
     * <p>
     * 通过商品编号查询评价总数
     * </p>
     *
     * @param itemNo 商品编号
     * @return int
     * @author LiuXiangLin
     * @date 10:26 2020/3/24
     **/
    int countByItemNo(int itemNo);

    /**
     * <p>
     * 通过商品编号以及星级查询评价数量
     * </p>
     *
     * @param itemNo       商品编号
     * @param praiseDegree 评价星级
     * @return int
     * @author LiuXiangLin
     * @date 10:32 2020/3/24
     **/
    int countByItemNoAndUpPraiseDegree(int itemNo, int praiseDegree);
}
