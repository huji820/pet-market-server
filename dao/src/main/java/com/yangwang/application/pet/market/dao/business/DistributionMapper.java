package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Distribution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 分销
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:13 2020/4/2
 **/
@Mapper
public interface DistributionMapper {

    /**
     * 获取分销列表
     *
     * @param businessNo
     * @param startDate
     * @param endDate
     * @param offset
     * @param limit
     * @return
     */
    List<Distribution> listDistribution(@Param("businessNo") String businessNo, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * <p>
     * 新增一条记录
     * </p>
     *
     * @param distribution 分销对象
     * @return int
     * @author LiuXiangLin
     * @date 10:27 2020/4/26
     **/
    int save(@Param("distribution") Distribution distribution);
}
