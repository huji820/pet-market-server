package com.yangwang.application.pet.market.dao.market;

import com.yangwang.application.pet.market.model.market.CreditFlow;
import com.yangwang.application.pet.market.model.params.QueryCreditFlowParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 积分流水
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:34 2020/3/19
 **/
public interface CreditFlowMapper {
    /**
     * <p>
     * 新增一条流水
     * </p>
     *
     * @param creditFlow 积分流水对象
     * @return int
     * @author LiuXiangLin
     * @date 10:35 2020/3/19
     **/
    int save(@Param("creditFlow") CreditFlow creditFlow);

    /**
     * <p>
     * 通过参数查询
     * </p>
     *
     * @param queryCreditFlowParam 查询参数对象
     * @return java.util.List<com.yangwang.application.pet.market.model.market.CreditFlow>
     * @author LiuXiangLin
     * @date 10:51 2020/3/19
     **/
    List<CreditFlow> list(@Param("queryCreditFlowParam") QueryCreditFlowParam queryCreditFlowParam);
}