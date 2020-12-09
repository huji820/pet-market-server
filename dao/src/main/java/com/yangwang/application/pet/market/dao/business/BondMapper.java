package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Bond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商家保证金
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:51 2020/3/24
 **/
@Mapper
public interface BondMapper {
    /**
     * <p>
     * 新增订单
     * </p>
     *
     * @param bond 订单保证金对象
     * @return int
     * @author LiuXiangLin
     * @date 14:39 2020/3/24
     **/
    int save(@Param("bond") Bond bond);

    /**
     * <p>
     * 修改保证金支付状态
     * </p>
     *
     * @param bondNo 保证金编号
     * @param state  状态
     * @return int
     * @author LiuXiangLin
     * @date 14:40 2020/3/24
     **/
    int updateState(@Param("bondNo") String bondNo, @Param("state") int state);


    /**
     * <p>
     * 获取保证金对象
     * </p>
     *
     * @param bondNo 保证金编号
     * @return com.yangwang.application.pet.market.model.business.Bond
     * @author LiuXiangLin
     * @date 14:43 2020/3/24
     **/
    Bond get(@Param("bondNo") String bondNo);

    /**
     * <p>
     * 通过商家编号查询保证金
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.business.Bond
     * @author LiuXiangLin
     * @date 14:44 2020/3/24
     **/
    Bond getByBusinessNo(@Param("businessNo") String businessNo);
}
