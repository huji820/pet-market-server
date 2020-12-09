package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.params.QueryQueryListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商家查询
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryBusinessMapper
 * @date 2020/3/25 10:16
 **/
public interface QueryBusinessMapper {
    /**
     * <p>
     * 通过商家关键词查询商家列表
     * </p>
     *
     * @param queryQueryListParam 查询对象
     * @return java.util.List<com.yangwang.application.pet.market.model.business.Business>
     * @author LiuXiangLin
     * @date 10:17 2020/3/25
     **/
    List<Business> listByQueryParam(@Param("queryQueryListParam") QueryQueryListParam queryQueryListParam);
}
