package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.PetWormKill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物杀虫记录
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetWormKillMapper
 * @date 2020/3/12 17:37
 **/
public interface PetWormKillMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petWormKill 宠物杀虫记录
     * @return int
     * @author LiuXiangLin
     * @date 17:40 2020/3/12
     **/
    int save(@Param("petWormKill") PetWormKill petWormKill);

    /**
     * <p>
     * 通过宠物主键删除所有的宠物杀虫记录
     * </p>
     *
     * @param petNo 宠物主键
     * @return int
     * @author LiuXiangLin
     * @date 17:40 2020/3/12
     **/
    int delete(@Param("petNo") String petNo);

    /**
     * <p>
     * 同时新增多条记录
     * </p>
     *
     * @param petWormKillList 宠物杀虫剂列表
     * @return int
     * @author LiuXiangLin
     * @date 17:40 2020/3/12
     **/
    int saveList(@Param("petWormKillList") List<PetWormKill> petWormKillList);

    /**
     * <p>
     * 通过宠物编号查虽所有的杀虫记录
     * </p>
     *
     * @param petNo 宠物编号
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetWormKill>
     * @author LiuXiangLin
     * @date 17:41 2020/3/12
     **/
    List<PetWormKill> listByPetNo(@Param("petNo") String petNo);
}
