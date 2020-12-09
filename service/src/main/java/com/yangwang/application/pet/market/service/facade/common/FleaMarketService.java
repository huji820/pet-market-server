package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.model.vo.PetVo;

import java.util.List;

/**
 * <p>
 * 跳蚤市场service
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FleaMarketService
 * @date 2020/3/14 14:55
 **/
public interface FleaMarketService {
    /**
     * <p>
     * 通过参数查询列表
     * </p>
     *
     * @param queryPetMarketListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetVo>
     * @author LiuXiangLin
     * @date 9:55 2020/3/17
     **/
    List<PetVo> list(QueryPetMarketListParam queryPetMarketListParam);
}
