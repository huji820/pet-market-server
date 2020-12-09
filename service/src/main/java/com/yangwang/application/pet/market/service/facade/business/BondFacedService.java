package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.Bond;

import java.util.Map;

/**
 * <p>
 * 商家保证金门店
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BondFacedService
 * @date 2020/3/24 15:19
 **/
public interface BondFacedService {
    /**
     * <p>
     * 新增一条保证金
     * </p>
     *
     * @param bond 保证金对象
     * @return int
     * @author LiuXiangLin
     * @date 15:22 2020/3/24
     **/
    int save(Bond bond);

    /**
     * <p>
     * 支付保证金
     * </p>
     *
     * @param bondNo 保证金编号
     * @return int
     * @author LiuXiangLin
     * @date 15:22 2020/3/24
     **/
    int payBond(String bondNo);

    /**
     * <p>
     * 获取保证金支付参数
     * </p>
     *
     * @param businessNo 商家编号
     * @param ipAddress  用户ip地址
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author LiuXiangLin
     * @date 15:30 2020/3/24
     **/
    Map<String, String> getBondPayParam(String businessNo, String ipAddress) throws Exception;

    /**
     * <p>
     * 通过商家编号查询商家保证金
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.business.Bond
     * @author LiuXiangLin
     * @date 17:00 2020/3/24
     **/
    Bond getByBusinessNo(String businessNo);

    /**
     * <p>
     * 支付回调
     * </p>
     *
     * @param bondNo 保证金单号
     * @return int
     * @author LiuXiangLin
     * @date 14:13 2020/4/1
     **/
    int payCallBack(String bondNo);
}
