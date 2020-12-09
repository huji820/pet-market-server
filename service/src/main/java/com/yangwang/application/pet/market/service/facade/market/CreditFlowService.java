package com.yangwang.application.pet.market.service.facade.market;


import com.yangwang.application.pet.market.model.market.CreditFlow;
import com.yangwang.application.pet.market.model.params.QueryCreditFlowParam;

import java.util.List;

/**
 * <p>
 * 积分流水
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:39 2020/3/19
 **/
public interface CreditFlowService {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @param creditFlow 积分流水
     * @return int
     * @author LiuXiangLin
     * @date 11:39 2020/3/19
     **/
    int save(CreditFlow creditFlow);

    /**
     * <p>
     * 查询积分流水列表
     * </p>
     *
     * @param queryCreditFlowParam 积分流失查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.market.CreditFlow>
     * @author LiuXiangLin
     * @date 11:40 2020/3/19
     **/
    List<CreditFlow> list(QueryCreditFlowParam queryCreditFlowParam);
}
