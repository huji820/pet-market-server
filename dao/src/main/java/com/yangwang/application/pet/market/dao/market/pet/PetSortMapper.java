package com.yangwang.application.pet.market.dao.market.pet;

import com.yangwang.application.pet.market.model.common.PetSort;

import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * <p>
 * 宠物一级分类
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:47 2020/3/22
 **/
@Mapper
public interface PetSortMapper {
    /**
     * <p>
     * 通过参数查询列表
     * </p>
     *
     * @param pagingQueryParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.common.PetSort>
     * @author LiuXiangLin
     * @date 11:45 2020/3/22
     **/
    List<PetSort> listByParam(@Param("pagingQueryParam") PagingQueryParam pagingQueryParam);

    /**
     * <p>
     * 通过一级编号获取数据
     * </p>
     *
     * @param petSortNo 宠物一级编号
     * @return com.yangwang.application.pet.market.model.common.PetSort
     * @author LiuXiangLin
     * @date 17:47 2020/3/26
     **/
    PetSort get(@Param("petSortNo") int petSortNo);
}
