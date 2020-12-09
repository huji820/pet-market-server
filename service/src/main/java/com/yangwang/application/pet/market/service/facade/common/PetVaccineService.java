package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetVaccine;

import java.util.List;

/**
 * <p>
 * 宠物疫苗
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetVaccineService
 * @date 2020/3/12 18:08
 **/
public interface PetVaccineService {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petVaccine 宠物疫苗对象
     * @return int
     * @author LiuXiangLin
     * @date 18:09 2020/3/12
     **/
    int save(PetVaccine petVaccine);

    /**
     * <p>
     * 新增多个宠物疫苗
     * </p>
     *
     * @param petVaccineList 宠物疫苗列表
     * @return int
     * @author LiuXiangLin
     * @date 18:10 2020/3/12
     **/
    int saveList(List<PetVaccine> petVaccineList);

    /**
     * <p>
     * 通过宠物主键删除所有的宠物疫苗信息
     * </p>
     *
     * @param petNo 宠物主键
     * @return int
     * @author LiuXiangLin
     * @date 18:10 2020/3/12
     **/
    int delete(String petNo);

    /**
     * <p>
     * 通过宠物主键查询所有的宠物疫苗
     * </p>
     *
     * @param petNo 宠物主键
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetVaccine>
     * @author LiuXiangLin
     * @date 18:11 2020/3/12
     **/
    List<PetVaccine> listByPetNo(String petNo);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param petVaccineList 疫苗列表
     * @param pet            宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 11:03 2020/3/13
     **/
    int updateList(List<PetVaccine> petVaccineList, Pet pet);
}
