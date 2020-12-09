package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.PetSort;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;

import java.util.List;

/**
 * <p>
 * 宠物一级分类
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:52 2020/3/22
 **/
public interface PetSortService {
    /**
     * <p>
     * 通过参数查询列表
     * </p>
     *
     * @param pagingQueryParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetSort>
     * @author LiuXiangLin
     * @date 11:51 2020/3/22
     **/
    List<PetSort> listByParam(PagingQueryParam pagingQueryParam);

    /**
     * <p>
     * 通过宠物以及分类编号查询对象
     * </p>
     *
     * @param petSortNo 宠物一级分类编号
     * @return com.yangwang.application.pet.market.model.common.PetSort
     * @author LiuXiangLin
     * @date 17:45 2020/3/26
     **/
    PetSort get(int petSortNo);
}
