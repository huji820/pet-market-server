package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.params.QueryPetAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.PetAppraiseVo;

import java.util.List;

/**
 * <p>
 * 宠物评论列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetAppraiseListService
 * @date 2020/3/23 17:55
 **/
public interface PetAppraiseListService {
    /**
     * <p>
     * 通过参数查询列表
     * </p>
     *
     * @param queryPetAppraiseListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.PetAppraiseVo>
     * @author LiuXiangLin
     * @date 17:57 2020/3/23
     **/
    List<PetAppraiseVo> list(QueryPetAppraiseListParam queryPetAppraiseListParam);
}
