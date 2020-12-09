package com.yangwang.application.pet.market.dao.market.pet;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 宠物权重
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetPowerMapper
 * @date 2020/3/17 15:05
 **/
public interface PetPowerMapper {
    /**
     * <p>
     * 更新宠物权重
     * </p>
     *
     * @param petNo 宠物编号
     * @param power 权重
     * @return int
     * @author LiuXiangLin
     * @date 15:06 2020/3/17
     **/
    int update(@Param("petNo") String petNo, @Param("power") int power);
}
