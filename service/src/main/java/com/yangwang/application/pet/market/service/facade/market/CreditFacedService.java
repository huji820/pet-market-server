package com.yangwang.application.pet.market.service.facade.market;

/**
 * <p>
 * 客户积分
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CreditFacedService
 * @date 2020/4/2 13:47
 **/
public interface CreditFacedService {
    /**
     * <p>
     * 添加积分
     * </p>
     *
     * @param businessNo 商家编号
     * @param credit     积分
     * @return int
     * @author LiuXiangLin
     * @date 13:48 2020/4/2
     **/
    int addCredit(String businessNo, int credit);
}
