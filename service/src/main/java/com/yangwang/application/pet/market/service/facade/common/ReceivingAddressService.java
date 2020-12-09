package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.common.ReceivingAddress;

import java.util.List;

/**
 * <p>
 * 收货地址
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:08 2020/3/27
 **/
public interface ReceivingAddressService {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param receivingAddress 收货地址对象
     * @return int
     * @author LiuXiangLin
     * @date 16:08 2020/3/27
     **/
    int save(ReceivingAddress receivingAddress);

    /**
     * <p>
     * 更新数据
     * </p>
     *
     * @param receivingAddress 收货地址对象
     * @return int
     * @author LiuXiangLin
     * @date 16:08 2020/3/27
     **/
    int update(ReceivingAddress receivingAddress);

    /**
     * <p>
     * 删除数据
     * </p>
     *
     * @param receivingNo 收货地址对象编号
     * @return int
     * @author LiuXiangLin
     * @date 16:09 2020/3/27
     **/
    int delete(int receivingNo);

    /**
     * <p>
     * 更新收货地址
     * </p>
     *
     * @param receivingAddress 收货地址对象
     * @return int
     * @author LiuXiangLin
     * @date 16:09 2020/3/27
     **/
    int updateDefault(ReceivingAddress receivingAddress);

    /**
     * <p>
     * 通过商家编号获取收货地址列表
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ReceivingAddress>
     * @author LiuXiangLin
     * @date 16:10 2020/3/27
     **/
    List<ReceivingAddress> listByBusinessNo(String businessNo);

    /**
     * <p>
     * 获取默认的收货地址
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.common.ReceivingAddress
     * @author LiuXiangLin
     * @date 16:20 2020/3/27
     **/
    ReceivingAddress getDefault(String businessNo);

    /**
     * <p>
     * 通过主键获取数据
     * </p>
     *
     * @param receivingNo 主键
     * @return com.yangwang.application.pet.market.model.common.ReceivingAddress
     * @author LiuXiangLin
     * @date 11:22 2020/3/28
     **/
    ReceivingAddress get(int receivingNo);
}
