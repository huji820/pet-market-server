package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.vo.ItemVo;

/**
 * <p>
 * 商品详情
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemDetailService
 * @date 2020/4/27 17:55
 **/
public interface ItemDetailService {
    /**
     * <p>
     * 通过主键获取商品详情
     * </p>
     *
     * @param itemNo 商品主键
     * @return com.yangwang.application.pet.market.model.vo.ItemVo
     * @author LiuXiangLin
     * @date 17:55 2020/4/27
     **/
    ItemVo get(int itemNo);
}
