package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemListMapper
 * @date 2020/3/22 9:00
 **/
@Mapper
public interface ItemListMapper {
    /**
     * <p>
     * 通过参数查询商品列表
     * </p>
     *
     * @param queryItemListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.common.Item>
     * @author LiuXiangLin
     * @date 9:12 2020/3/22
     **/
    List<ItemVo> list(@Param("queryItemListParam") QueryItemListParam queryItemListParam);

    /**
     * 获取厂家商品
     * @param listManufactor
     * @return
     */
    List<ItemVo> listManufactorItem(@Param("listManufactor")List<String> listManufactor);
}
