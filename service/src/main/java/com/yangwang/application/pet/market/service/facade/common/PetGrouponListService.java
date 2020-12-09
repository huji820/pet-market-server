package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;

import java.util.List;

/**
 * <p>
 * 宠物团购列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGrouponListService
 * @date 2020/3/25 16:12
 **/
public interface PetGrouponListService {
    /**
     * <p>
     * 通过多个参数查询列表
     * </p>
     *
     * @param queryPetMarketListParam 查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 16:26 2020/3/25
     **/
    List<PetVo> listByParam(QueryPetMarketListParam queryPetMarketListParam);
}
