package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 收货地址
 * </p>
 *
 * @author LiuXiangLin
 * @date 15:42 2020/3/27
 **/
@Mapper
public interface ReceivingAddressMapper {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param receivingAddress 收货地址
     * @return int
     * @author LiuXiangLin
     * @date 15:42 2020/3/27
     **/
    int save(@Param("receivingAddress") ReceivingAddress receivingAddress);

    /**
     * <p>
     * 通过主键删除数据
     * </p>
     *
     * @param receivingNo 收货地址主键
     * @return int
     * @author LiuXiangLin
     * @date 15:42 2020/3/27
     **/
    int delete(@Param("receivingNo") int receivingNo);

    /**
     * <p>
     * 通过主键获取收货地址
     * </p>
     *
     * @param receivingNo 收货地址主键
     * @return com.yangwang.application.pet.market.model.common.ReceivingAddress
     * @author LiuXiangLin
     * @date 15:43 2020/3/27
     **/
    ReceivingAddress get(@Param("receivingNo") int receivingNo);

    /**
     * <p>
     * 更新收货地址
     * </p>
     *
     * @param receivingAddress 收货地址
     * @return int
     * @author LiuXiangLin
     * @date 15:43 2020/3/27
     **/
    int update(@Param("receivingAddress") ReceivingAddress receivingAddress);

    /**
     * <p>
     * 通过用户主键查询收货地址列表
     * </p>
     *
     * @param businessNo 用户主键
     * @return java.util.List<com.yangwang.application.pet.market.model.common.ReceivingAddress>
     * @author LiuXiangLin
     * @date 15:44 2020/3/27
     **/
    List<ReceivingAddress> listByBusinessNo(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 设置为默认收货地址
     * </p>
     *
     * @param businessNo  收货地址编号
     * @param receivingNo 收货地址编号
     * @return int
     * @author LiuXiangLin
     * @date 16:00 2020/3/27
     **/
    int updateDefault(@Param("businessNo") String businessNo, @Param("receivingNo") int receivingNo);

    /**
     * <p>
     * 更新所有的收货地址为不默认
     * </p>
     *
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 16:01 2020/3/27
     **/
    int updateAllToNoDefault(@Param("businessNo") String businessNo);

    /**
     * <p>
     * 获取商家默认的收货地址
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.common.ReceivingAddress
     * @author LiuXiangLin
     * @date 16:23 2020/3/27
     **/
    ReceivingAddress getDefault(@Param("businessNo") String businessNo);
}
