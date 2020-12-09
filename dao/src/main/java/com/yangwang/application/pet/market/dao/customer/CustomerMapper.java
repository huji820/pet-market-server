package com.yangwang.application.pet.market.dao.customer;

import com.yangwang.application.pet.market.model.common.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 用户
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CustomerMapper
 * @date 2019/10/26 10:28
 **/
@Mapper
public interface CustomerMapper {
    /**

     * @description 根据unionId查询数据
     * @return com.yangwang.application.pet.market.model.common.Customer
     * @author lsy
     * @date 14:39 2019/12/2
     **/
    Customer getByUnionId(String unionId);

    /**
     *
     * 用户注册
     * @param customer 用户对象
     * @return int
     * @author yang hituzi
     * @date 10:44 2019/10/31
     */
    int insertCustomer(@Param("customer") Customer customer);

    /**

     * @description 修改customer信息
     * @return
     * @author lsy
     * @date 9:33 2019/11/13
     **/
    int updateCustomer(@Param("customer") Customer customer);

    /**
     * <p>
     * 通过电话号码获取用户信息
     * </p>
     *
     * @param phone 电话号码
     * @return com.yangwang.application.pet.market.model.common.Customer
     * @author LiuXiangLin
     * @date 16:50 2020/5/11
     **/
    Customer getByPhone(@Param("phone")String phone);

    /**
     * @Description: 获取用户的推荐人编号
     * @Author: zxj
     * @Date: 2020/9/7 10:42
     * @param customerNo: 用户编号
     * @return: java.lang.String
     **/
    String getCustomerRecommendBusinessNo(@Param("customerNo")String customerNo);

    /**
     * @Description: 获取用户的推荐站点的主号商家编号
     * @Author: zxj
     * @Date: 2020/9/7 10:47
     * @param customerNo: 用户编号
     * @return: java.lang.String
     **/
    String getCustomerRecommendStationNo(@Param("customerNo")String customerNo);
}
