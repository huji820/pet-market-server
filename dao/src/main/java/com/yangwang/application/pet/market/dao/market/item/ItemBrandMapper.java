package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.ItemBrand;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品品牌
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:30 2020/3/22
 **/
@Mapper
public interface ItemBrandMapper {
    /**
     * <p>
     * 通过参数查询品牌列表
     * </p>
     *
     * @param pagingQueryParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemBrand>
     * @author LiuXiangLin
     * @date 10:29 2020/3/22
     **/
    List<ItemBrand> listByParam(@Param("pagingQueryParam") PagingQueryParam pagingQueryParam);
}
