package com.yangwang.application.pet.market.service.facade.customer;

import java.math.BigDecimal;

/**
 * <p>
 * 宠物好评率
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetFavorableRateService
 * @date 2020/3/23 13:39
 **/
public interface PetFavorableRateService {
    /**
     * <p>
     * 计算好评率
     * </p>
     *
     * @param petNo 宠物编号
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 13:44 2020/3/23
     **/
    BigDecimal calcFavorableRate(String petNo);
}
