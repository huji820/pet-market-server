package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.params.QueryPetBusinessListParam;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 宠物列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetListMapper
 * @date 2020/3/20 9:18
 **/
@Mapper
public interface PetListMapper {
    /**
     * <p>
     * 查询宠物列表
     * </p>
     *
     * @param queryPetBusinessListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 9:34 2020/3/20
     **/
    List<PetVo> listBusinessPet(@Param("queryPetBusinessListParam") QueryPetBusinessListParam queryPetBusinessListParam);

    /**
     * <p>
     * 通过多个参数查询宠物列表
     * </p>
     *
     * @param queryPetMarketListParam 查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 8:46 2020/4/28
     **/
    List<PetVo> listMarketPet(@Param("queryPetMarketListParam")QueryPetMarketListParam queryPetMarketListParam);
}
