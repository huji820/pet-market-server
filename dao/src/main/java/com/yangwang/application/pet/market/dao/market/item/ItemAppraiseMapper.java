package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.market.ItemAppraise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:10 2020/3/24
 **/
@Mapper
public interface ItemAppraiseMapper {
    /**
     * <p>
     * 新增一条评价
     * </p>
     *
     * @param itemAppraise 商品评价对象
     * @return int
     * @author LiuXiangLin
     * @date 9:11 2020/3/24
     **/
    int save(@Param("itemAppraise") ItemAppraise itemAppraise);

    /**
     * <p>
     * 删除一条评价
     * </p>
     *
     * @param itemAppraiseNo 商品评价编号
     * @return int
     * @author LiuXiangLin
     * @date 9:12 2020/3/24
     **/
    int delete(@Param("itemAppraiseNo") int itemAppraiseNo);

    /**
     * <p>
     * 通过多个条件查询评价
     * </p>
     *
     * @param itemAppraise 商品评价对象
     * @return com.yangwang.application.pet.market.model.market.ItemAppraise
     * @author LiuXiangLin
     * @date 9:43 2020/3/24
     **/
    ItemAppraise getByAppraise(@Param("itemAppraise") ItemAppraise itemAppraise);

    /**
     * <p>
     * 通过商品评价编查询评价
     * </p>
     *
     * @param itemAppraiseNo 宠物评价编号
     * @return com.yangwang.application.pet.market.model.market.ItemAppraise
     * @author LiuXiangLin
     * @date 9:49 2020/3/24
     **/
    ItemAppraise get(@Param("itemAppraiseNo") int itemAppraiseNo);

    /**
     * <p>
     * 通过宠物主键查询所有的评价数量
     * </p>
     *
     * @param itemNo 商品编号
     * @return int
     * @author LiuXiangLin
     * @date 10:27 2020/3/24
     **/
    int countByItemNo(@Param("itemNo") int itemNo);

    /**
     * <p>
     * 通过商品编号以及星级查询总的评价数量
     * </p>
     *
     * @param itemNo       商品编号
     * @param praiseDegree 评价星数
     * @return int
     * @author LiuXiangLin
     * @date 10:29 2020/3/24
     **/
    int countByItemNoAndUpPraiseDegree(@Param("itemNo") int itemNo, @Param("praiseDegree") int praiseDegree);
}
