package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.PetVaccine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物疫苗
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetVaccineMapper
 * @date 2020/3/12 17:59
 **/
public interface PetVaccineMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param petVaccine 宠物疫苗对象
     * @return int
     * @author LiuXiangLin
     * @date 18:00 2020/3/12
     **/
    int save(@Param("petVaccine") PetVaccine petVaccine);

    /**
     * <p>
     * 新增多条宠物疫苗数据
     * </p>
     *
     * @param petVaccineList 宠物疫苗列表
     * @return int
     * @author LiuXiangLin
     * @date 18:00 2020/3/12
     **/
    int saveList(@Param("petVaccineList") List<PetVaccine> petVaccineList);

    /**
     * <p>
     * 通过宠物编号删除数据
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 18:01 2020/3/12
     **/
    int delete(@Param("petNo") String petNo);

    /**
     * <p>
     * 通过宠主键查询疫苗列表
     * </p>
     *
     * @param petNo 宠物主键
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetVaccine>
     * @author LiuXiangLin
     * @date 18:01 2020/3/12
     **/
    List<PetVaccine> listByPetNo(@Param("petNo") String petNo);
}
