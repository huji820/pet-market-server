package com.yangwang.application.pet.market.dao.common;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.model.params.QueryFansListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户粉丝
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FansMapper
 * @date 2020/3/25 9:12
 **/
public interface FansMapper {
    /**
     * <p>
     * 通过查询查询商家列表
     * </p>
     *
     * @param queryFansListParam 查询参数
     * @return java.util.List<com.yangwang.application.pet.market.model.business.Follow>
     * @author LiuXiangLin
     * @date 9:20 2020/3/25
     **/
    List<Follow> listByParam(@Param("queryFansListParam") QueryFansListParam queryFansListParam);
}
