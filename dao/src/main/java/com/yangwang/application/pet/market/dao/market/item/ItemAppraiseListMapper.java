package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.params.QueryItemAppraiseListParam;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseListMapper
 * @date 2020/3/24 11:30
 **/
public interface ItemAppraiseListMapper {
    /**
     * <p>
     * 通过查询参数查询评价列表
     * </p>
     *
     * @param queryItemAppraiseListParam 查询参数列表
     * @return java.util.List<com.yangwang.application.pet.market.model.vo.ItemAppraiseVo>
     * @author LiuXiangLin
     * @date 11:35 2020/3/24
     **/
    List<ItemAppraiseVo> listByParam(@Param("queryItemAppraiseListParam") QueryItemAppraiseListParam queryItemAppraiseListParam);
}
