package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryPetBusinessListParam;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;

import java.util.List;

/**
 * <p>
 * 宠物列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetListService
 * @date 2020/3/20 10:11
 **/
public interface PetListService {
    /**
     * <p>
     * 查询商家宠物列表
     * </p>
     *
     * @param queryPetBusinessListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 10:12 2020/3/20
     **/
    List<PetVo> listBusinessPet(QueryPetBusinessListParam queryPetBusinessListParam);

    /**
     * <p>
     * 通过条件查询所有的宠物
     * </p>
     *
     * @param queryPetMarketListParam 查询条件
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 18:03 2020/4/27
     **/
    List<PetVo> listMarketPet(QueryPetMarketListParam queryPetMarketListParam);
}
