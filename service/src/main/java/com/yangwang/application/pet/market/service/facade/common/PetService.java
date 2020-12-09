package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Pet;

import java.math.BigDecimal;

/**
 * <p>
 * 商家宠物
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:25 2020/3/13
 **/
public interface PetService {
    /**
     * <p>
     * 新增宠物
     * </p>
     *
     * @param pet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 9:26 2020/3/13
     **/
    int save(Pet pet);

    /**
     * <p>
     * 修改宠物状态（上架与下架）
     * </p>
     *
     * @param petNo 订单编号
     * @param state 宠物状态
     * @return int
     * @author LiuXiangLin
     * @date 9:26 2020/3/13
     **/
    int updatePetState(String petNo, int state);

    /**
     * <p>
     * 更新宠物属性
     * </p>
     *
     * @param pet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 9:27 2020/3/13
     **/
    int update(Pet pet);

    /**
     * 更新宠物是否被售出
     * @param petNo  宠物编号
     * @param petIsSell  0 未售出   1 已售出
     * @return
     */
    int updatePetIsSell(String petNo,int petIsSell);

    /**
     * <p>
     * 创建一个新的宠物主键
     * </p>
     *
     * @param business 商家对象
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 9:54 2020/3/13
     **/
    String newPetNo(Business business);

    /**
     * <p>
     * 新增收藏量
     * </p>
     *
     * @param petNo      宠物编号
     * @param collection 收藏量
     * @return int
     * @author LiuXiangLin
     * @date 11:15 2020/3/21
     **/
    int updateCollectionAdd(String petNo, int collection);

    /**
     * <p>
     * 减少收藏量
     * </p>
     *
     * @param petNo      宠物编号
     * @param collection 收藏量
     * @return int
     * @author LiuXiangLin
     * @date 11:17 2020/3/21
     **/
    int updateCollectionSub(String petNo, int collection);

    /**
     * <p>
     * 增加评价数量
     * </p>
     *
     * @param petNo      宠物编号
     * @param evaluation 购买数量
     * @return int
     * @author LiuXiangLin
     * @date 11:02 2020/3/23
     **/
    int updateEvaluationQtyAdd(String petNo, int evaluation);

    /**
     * <p>
     * 减少评价数量
     * </p>
     *
     * @param petNo      宠物编号
     * @param evaluation 购买数量
     * @return int
     * @author LiuXiangLin
     * @date 11:15 2020/3/23
     **/
    int updateEvaluationQtySub(String petNo, int evaluation);

    /**
     * <p>
     * 修改宠物好评率
     * </p>
     *
     * @param petNo         宠物比那好
     * @param favorableRate 好评率
     * @return int
     * @author LiuXiangLin
     * @date 14:10 2020/3/23
     **/
    int updateFavorableRate(String petNo, BigDecimal favorableRate);

    /**
     * <p>
     * 给商品添加销量
     * </p>
     *
     * @param petNo       宠物编号
     * @param salesVolume 销量
     * @return int
     * @author LiuXiangLin
     * @date 14:21 2020/4/26
     **/
    int updateSalesVolumeAdd(String petNo, int salesVolume);

    /**
     * <p>
     * 通过主键获取宠物
     * </p>
     *
     * @param petNo 宠物
     * @return com.yangwang.application.pet.market.model.common.Pet
     * @author LiuXiangLin
     * @date 17:35 2020/3/26
     **/
    Pet get(String petNo);
}
