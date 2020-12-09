package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.market.PetAppraise;


/**
 * <p>
 * 宠物评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:46 2020/3/23
 **/
public interface PetAppraiseService {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petAppraise 宠物评价对象
     * @return int
     * @author LiuXiangLin
     * @date 10:47 2020/3/23
     **/
    int save(PetAppraise petAppraise);

    /**
     * <p>
     * 删除一条数据
     * </p>
     *
     * @param petAppraiseNo 评价主键
     * @return int
     * @author LiuXiangLin
     * @date 10:47 2020/3/23
     **/
    int delete(int petAppraiseNo);

    /**
     * <p>
     * 通过主键获取数据
     * </p>
     *
     * @param petAppraiseNo 评价主键
     * @return int
     * @author LiuXiangLin
     * @date 11:38 2020/3/23
     **/
    PetAppraise get(int petAppraiseNo);

    /**
     * <p>
     * 通过宠物编号查询评价总数
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 13:46 2020/3/23
     **/
    int countByPetNo(String petNo);

    /**
     * <p>
     * 通过某一星级查询总数
     * </p>
     *
     * @param petNo        宠物编号
     * @param praiseDegree 评分星级（包含）
     * @return int
     * @author LiuXiangLin
     * @date 13:51 2020/3/23
     **/
    int countByUpPraiseDegree(String petNo, int praiseDegree);

    /**
     * <p>
     * 通过多个条件查询是否存在
     * </p>
     *
     * @param petAppraise 宠物评价
     * @return com.yangwang.application.pet.market.model.market.PetAppraise
     * @author LiuXiangLin
     * @date 14:38 2020/3/23
     **/
    PetAppraise getByPetAppraise(PetAppraise petAppraise);

}
