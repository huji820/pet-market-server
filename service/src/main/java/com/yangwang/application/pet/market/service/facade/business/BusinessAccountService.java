package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.BusinessAccount;

import java.util.List;

/**
 * <p>
 * 商家收款账户
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAccountService
 * @date 2020/5/20 13:59
 **/
public interface BusinessAccountService {
    /**
     * <p>
     * 保存一条收款账户信息
     * </p>
     *
     * @param businessAccount 商家账户信息
     * @return int
     * @author LiuXiangLin
     * @date 14:00 2020/5/20
     **/
    int save(BusinessAccount businessAccount);

    /**
     * <p>
     * 通过商家编号查询所有的收款账户
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.business.BusinessAccount>
     * @author LiuXiangLin
     * @date 14:00 2020/5/20
     **/
    List<BusinessAccount> listByBusinessNo(String businessNo);

    /**
     * <p>
     * 通过主键删除数据
     * </p>
     *
     * @param accountNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 14:02 2020/5/20
     **/
    int delete(long accountNo);
}
