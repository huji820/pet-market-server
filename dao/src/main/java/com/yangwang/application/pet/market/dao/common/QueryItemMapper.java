package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemBrand;
import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品品牌
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryItemBrandMapper
 * @date 2020/3/25 10:31
 **/
public interface QueryItemMapper {
    /**
     * <p>
     * 通过关键字查询商品品牌列表
     * </p>
     *
     * @param queryQueryListParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ItemBrand>
     * @author LiuXiangLin
     * @date 10:31 2020/3/25
     **/
    List<Item> listByParam(@Param("queryQueryListParam") QueryQueryListParam queryQueryListParam);
}
