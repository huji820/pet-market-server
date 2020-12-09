package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;

import java.util.List;

/**
 * <p>
 * 高端宠物
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className HighQualityService
 * @date 2020/3/17 9:24
 **/
public interface HighQualityService {
    /**
     * <p>
     * 通过参数查询里列表
     * </p>
     *
     * @param queryPetMarketListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 9:54 2020/3/17
     **/
    List<PetVo> list(QueryPetMarketListParam queryPetMarketListParam);
}
