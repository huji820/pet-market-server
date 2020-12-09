package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.ItemPack;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 商品套餐
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:11 2020/3/22
 **/
@Mapper
public interface ItemPackMapper {
    /**
     * <p>
     * 查询所有的套餐
     * </p>
     *
     * @param pagingQueryParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemPack>
     * @author LiuXiangLin
     * @date 10:14 2020/3/22
     **/
    List<ItemPack> listByParam(@Param("pagingQueryParam") PagingQueryParam pagingQueryParam);
}
