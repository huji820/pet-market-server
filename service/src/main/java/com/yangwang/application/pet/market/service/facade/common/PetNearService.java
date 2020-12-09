package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;

import java.util.List;

public interface PetNearService {

    /**
     *
     * 通过参数查询里 附近的宠物列表
     * @param queryPetMarketListParam
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author yang hituzi
     * @date 14:58 2020/4/10
     */
    List<PetVo> list(QueryPetMarketListParam queryPetMarketListParam);
}
