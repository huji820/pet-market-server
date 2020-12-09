package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetCover;

import java.util.List;

/**
 * <p>
 * 宠物封面
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetCoverService
 * @date 2020/3/12 16:51
 **/
public interface PetCoverService {
    /**
     * <p>
     * 新增宠物封面
     * </p>
     *
     * @param petCover 宠物封面对象
     * @return int
     * @author LiuXiangLin
     * @date 16:53 2020/3/12
     **/
    int save(PetCover petCover);

    /**
     * <p>
     * 通过宠物主键删除数据
     * </p>
     *
     * @param petNo 宠物主键
     * @return int
     * @author LiuXiangLin
     * @date 16:53 2020/3/12
     **/
    int delete(String petNo);

    /**
     * <p>
     * 通过宠物编号查询宠物封面
     * </p>
     *
     * @param petNo 宠物编号
     * @return com.yangwang.application.pet.market.model.common.PetCover
     * @author LiuXiangLin
     * @date 16:54 2020/3/12
     **/
    List<PetCover> getByPetNo(String petNo);

    /**
     * <p>
     * 新增一个列表
     * </p>
     *
     * @param petCovers 宠物封面列表
     * @return int
     * @author LiuXiangLin
     * @date 18:17 2020/3/12
     **/
    int saveList(List<PetCover> petCovers);

    /**
     * <p>
     * 更新列表
     * </p>
     *
     * @param petCoverList 封面列表
     * @param pet          宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 11:15 2020/3/13
     **/
    int updateList(List<PetCover> petCoverList, Pet pet);
}
