package com.yangwang.application.pet.market.dao.market.item;

import com.yangwang.application.pet.market.model.vo.ItemVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品明细
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemDetailMapper
 * @date 2020/4/27 17:39
 **/
public interface ItemDetailMapper {
    /**
     * <p>
     * 通过主键获取商品详情
     * </p>
     *
     * @param itemNo 商品编号
     * @return com.yangwang.application.pet.market.model.vo.ItemVo
     * @author LiuXiangLin
     * @date 17:39 2020/4/27
     **/
    ItemVo get(@Param("itemNo") int itemNo);
}
