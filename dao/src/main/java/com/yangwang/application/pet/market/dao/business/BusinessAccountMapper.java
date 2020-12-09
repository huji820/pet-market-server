package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.BusinessAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家收款账户
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessAccountMapper
 * @date 2020/5/20 11:47
 **/
public interface BusinessAccountMapper {
    /**
     * <p>
     * 新增一条商家收款账户
     * </p>
     *
     * @param businessAccount 商家收款账户
     * @return int
     * @author LiuXiangLin
     * @date 11:49 2020/5/20
     **/
    int save(@Param("businessAccount") BusinessAccount businessAccount);

    /**
     * <p>
     * 通过商家编号查询所有的收款账户
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.business.BusinessAccount>
     * @author LiuXiangLin
     * @date 13:53 2020/5/20
     **/
    List<BusinessAccount> listByBusinessNo(@Param("businessNo")String businessNo);

    /**
     * <p>
     * 删除一条记录
     * </p>
     *
     * @param accountNo 主键
     * @return int
     * @author LiuXiangLin
     * @date 14:03 2020/5/20
     **/
    int delete(@Param("accountNo") long accountNo);
}
