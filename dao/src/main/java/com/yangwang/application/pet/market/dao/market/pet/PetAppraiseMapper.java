package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.market.PetAppraise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 宠物评价
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:35 2020/3/23
 **/
@Mapper
public interface PetAppraiseMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petAppraise 宠物评价
     * @return int
     * @author LiuXiangLin
     * @date 10:33 2020/3/23
     **/
    int save(@Param("petAppraise") PetAppraise petAppraise);

    /**
     * <p>
     * 通过主键删除评价
     * </p>
     *
     * @param petAppraiseNo 宠物评价编号
     * @return int
     * @author LiuXiangLin
     * @date 10:34 2020/3/23
     **/
    int delete(@Param("petAppraiseNo") int petAppraiseNo);

    /**
     * <p>
     * 通过主键获取评论
     * </p>
     *
     * @param petAppraiseNo 宠物评价主键
     * @return com.yangwang.application.pet.market.model.market.PetAppraise
     * @author LiuXiangLin
     * @date 11:39 2020/3/23
     **/
    PetAppraise get(@Param("petAppraiseNo") int petAppraiseNo);

    /**
     * <p>
     * 通过宠物编号查询评价总条数
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 13:47 2020/3/23
     **/
    int countByPetNo(@Param("petNo") String petNo);

    /**
     * <p>
     * 通过星级和宠物编号查询数据
     * </p>
     *
     * @param petNo        宠物编号
     * @param praiseDegree 宠物星级
     * @return int
     * @author LiuXiangLin
     * @date 13:57 2020/3/23
     **/
    int countByUpPraiseDegree(@Param("petNo") String petNo, @Param("praiseDegree") int praiseDegree);

    /**
     * <p>
     * 通过评价对象查询评价
     * </p>
     *
     * @param petAppraise 评价对象
     * @return com.yangwang.application.pet.market.model.market.PetAppraise
     * @author LiuXiangLin
     * @date 14:39 2020/3/23
     **/
    PetAppraise getByPetAppraise(@Param("petAppraise") PetAppraise petAppraise);
}
