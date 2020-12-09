package com.yangwang.application.pet.market.service.service;

import com.yangwang.application.pet.market.model.business.Bond;

/**
 * <p>
 * 商家保证金
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:53 2020/3/24
 **/
public interface BondService {
    /**
     * <p>
     * 保存一条商家保证金记录
     * </p>
     *
     * @param bond 保证金对象
     * @return int
     * @author LiuXiangLin
     * @date 14:54 2020/3/24
     **/
    int save(Bond bond);

    /**
     * <p>
     * 修改保证金支付状态
     * </p>
     *
     * @param bondNo 保证金编号
     * @param state  保证金状态
     * @return int
     * @author LiuXiangLin
     * @date 14:55 2020/3/24
     **/
    int updateState(String bondNo, int state);

    /**
     * <p>
     * 通过保证金主键获取保证金
     * </p>
     *
     * @param bondNo 保证金主键
     * @return Bond
     * @author LiuXiangLin
     * @date 14:56 2020/3/24
     **/
    Bond get(String bondNo);

    /**
     * <p>
     * 通过商家编号获取保证金
     * </p>
     *
     * @param businessNo 商家编号
     * @return Bond
     * @author LiuXiangLin
     * @date 14:56 2020/3/24
     **/
    Bond getByBusinessNo(String businessNo);
}