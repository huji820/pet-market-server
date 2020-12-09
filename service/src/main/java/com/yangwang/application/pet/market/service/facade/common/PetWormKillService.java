package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetWormKill;

import java.util.List;

/**
 * <p>
 * 杀虫记录
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetWormKillService
 * @date 2020/3/12 17:50
 **/
public interface PetWormKillService {
    /**
     * <p>
     * 保存一条杀虫记录
     * </p>
     *
     * @param petWormKill 杀虫记录对象
     * @return int
     * @author LiuXiangLin
     * @date 17:51 2020/3/12
     **/
    int save(PetWormKill petWormKill);

    /**
     * <p>
     * 保存一列杀虫记录
     * </p>
     *
     * @param petWormKillList 杀虫记录列表
     * @return int
     * @author LiuXiangLin
     * @date 17:52 2020/3/12
     **/
    int saveList(List<PetWormKill> petWormKillList);

    /**
     * <p>
     * 通过宠物编号删除数据
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 17:53 2020/3/12
     **/
    int delete(String petNo);

    /**
     * <p>
     * 通过出宠物编号查询杀虫记录
     * </p>
     *
     * @param petNo 宠物编号
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetWormKill>
     * @author LiuXiangLin
     * @date 17:53 2020/3/12
     **/
    List<PetWormKill> listByPetNo(String petNo);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param petWormKillList 更新列表
     * @param pet             宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 10:55 2020/3/13
     **/
    int updateList(List<PetWormKill> petWormKillList, Pet pet);
}
