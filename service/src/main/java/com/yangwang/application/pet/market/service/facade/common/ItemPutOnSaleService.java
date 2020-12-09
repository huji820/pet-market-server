package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.vo.ItemVo;

/**
 * <p>
 * 商品发布
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemPutOnSaleService
 * @date 2020/3/22 15:59
 **/
public interface ItemPutOnSaleService {
    /**
     * <p>
     * 商品上架
     * </p>
     *
     * @param itemNo 商品编号
     * @return int
     * @author LiuXiangLin
     * @date 16:11 2020/3/22
     **/
    int putOnSale(int itemNo);

    /**
     * <p>
     * 商品下架
     * </p>
     *
     * @param itemNo 商品编号
     * @return int
     * @author LiuXiangLin
     * @date 16:12 2020/3/22
     **/
    int pullOffShelves(int itemNo);

    /**
     * <p>
     * 商品新上架
     * </p>
     *
     * @param itemVo 商品对象
     * @return int
     * @author LiuXiangLin
     * @date 16:12 2020/3/22
     **/
    int newPutOnSale(ItemVo itemVo);

    /**
     * <p>
     * 修改发布
     * </p>
     *
     * @param itemVo 商品对象
     * @return int
     * @author LiuXiangLin
     * @date 16:38 2020/3/22
     **/
    int update(ItemVo itemVo);
}
