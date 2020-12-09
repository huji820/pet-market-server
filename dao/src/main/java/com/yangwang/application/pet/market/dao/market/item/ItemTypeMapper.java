package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.common.ItemType;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品类别
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemTypeMapper
 * @date 2020/3/22 10:45
 **/
@Mapper
public interface ItemTypeMapper {
    /**
     * <p>
     * 通过参数查询商品类别
     * </p>
     *
     * @param pagingQueryParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemType>
     * @author LiuXiangLin
     * @date 10:49 2020/3/22
     **/
    List<ItemType> listByParam(@Param("pagingQueryParam") PagingQueryParam pagingQueryParam);
}
