package com.yangwang.application.pet.market.service.facade.customer;

import java.math.BigDecimal;

/**
 * <p>
 * 商品好评率
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemFavorableRateService
 * @date 2020/3/24 10:22
 **/
public interface ItemFavorableRateService {
    /**
     * <p>
     * 计算商品的好评率
     * </p>
     *
     * @param itemNo 商品编号
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 10:23 2020/3/24
     **/
    BigDecimal calcFavorableRate(int itemNo);
}
