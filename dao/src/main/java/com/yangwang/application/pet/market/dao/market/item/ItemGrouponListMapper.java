package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemGrouponListMapper
 * @date 2020/5/26 10:05
 **/
public interface ItemGrouponListMapper {
    /**
     * <p>
     * 通过条件查询列表
     * </p>
     *
     * @param queryItemListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ItemVo>
     * @author LiuXiangLin
     * @date 10:06 2020/5/26
     **/
    List<ItemVo> listByParam(@Param("queryItemListParam") QueryItemListParam queryItemListParam);
}
