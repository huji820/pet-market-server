package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetGroupon;

import java.util.List;

/**
 * <p>
 * 宠物团购
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGrouponService
 * @date 2020/3/25 14:38
 **/
public interface PetGrouponService {
    /**
     * <p>
     * 保存一个列表
     * </p>
     *
     * @param petGrouponList 团购列表
     * @return int
     * @author LiuXiangLin
     * @date 14:39 2020/3/25
     **/
    int saveList(List<PetGroupon> petGrouponList);

    /**
     * <p>
     * 保存一条数据
     * </p>
     *
     * @param petGroupon 团购列表
     * @return int
     * @author LiuXiangLin
     * @date 14:39 2020/3/25
     **/
    int save(PetGroupon petGroupon);

    /**
     * <p>
     * 通过宠物编号删除数据
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 14:40 2020/3/25
     **/
    int deleteByPetNo(String petNo);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param petGrouponList 宠物价格等级列表
     * @param pet            宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 10:21 2020/3/26
     **/
    int updateList(List<PetGroupon> petGrouponList, Pet pet);
}
