package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Pet;

/**
 * <p>
 * 宠物权重service
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetPowerService
 * @date 2020/3/17 11:11
 **/
public interface PetPowerService {
    /**
     * <p>
     * 获取权重值
     * </p>
     *
     * @param business 商家对象
     * @param pet      宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 11:12 2020/3/17
     **/
    int get(Pet pet, Business business);

    /**
     * <p>
     * 更新宠物权重
     * </p>
     *
     * @param petNo 宠物对象
     * @param power 权重
     * @return int
     * @author LiuXiangLin
     * @date 15:03 2020/3/17
     **/
    int update(String petNo, int power);
}
