package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.common.Customer;

/**
 * 用户Service
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CustomerService
 * @date 2019/10/26 10:24
 **/
public interface CustomerService {
    /**

     * @description 通过unionId查询用户
     * @return
     * @author lsy
     * @date 14:37 2019/12/2
     **/
    Customer getByUnionId(String unionId);
    /**
     *
     * 用户注册
     * @param customer
     * @return Customer
     * @author yang hituzi
     * @date 10:32 2019/10/31
     */
    Customer insertCustomer(Customer customer);

    /**
     * <p>
     * 通过电话号码查询用户信息
     * </p>
     *
     * @param phone 电话号码
     * @return com.yangwang.application.pet.market.model.common.Customer
     * @author LiuXiangLin
     * @date 16:49 2020/5/11
     **/
    Customer getByPhone(String phone);

    /**
     * @Description: 获取用户的推荐者
     * @Author: zxj
     * @Date: 2020/9/7 10:52
     * @param customerNo: 用户编号
     * @return: java.lang.String
     **/
    String getBusinessReferee(String customerNo);
}
