package com.yangwang.application.pet.market.dao.business;

import com.yangwang.application.pet.market.model.business.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *   厂家和分仓关联mapper
 * </p>
 * @Author zhouxiaojian
 * @Date 2020/8/21 15:13
 * @Version 1.0
 */
@Mapper
public interface SupplyRelationMapper {

    /**
     * 添加分仓
     * @param businessNo  分仓编号
     * @param manufactorNo  厂家编号
     * @return
     */
    int addSubWarehouse(@Param("businessNo")String businessNo,
                        @Param("manufactorNo")String manufactorNo);


    /**
     * 通过分仓编号获取所有相关的厂家编号
     * @param businessNo
     * @return
     */
    List<String> listManufactor(@Param("businessNo")String businessNo);

    /**
     * 通过厂家编号获取所有相关的分仓编号
     * @param businessNo
     * @return
     */
    List<String> listSubWarehouse(@Param("businessNo")String businessNo);
}
