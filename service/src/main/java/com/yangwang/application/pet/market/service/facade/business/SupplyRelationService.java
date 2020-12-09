package com.yangwang.application.pet.market.service.facade.business;

import com.yangwang.application.pet.market.model.business.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *   厂家和分仓关联service
 * </p>
 * @Author zhouxiaojian
 * @Date 2020/8/21 15:13
 * @Version 1.0
 */
public interface SupplyRelationService {

    /**
     * 添加分仓
     * @param businessNoList  分仓编号
     * @param manufactorNo  厂家编号
     * @return
     */
    int addSubWarehouse(List<String> businessNoList, String manufactorNo);

    /**
     * 通过分仓的编号获取所有相关的厂家
     * @param businessNo
     * @return
     */
    List<Business> listManufactor(String businessNo);

    /**
     * 通过厂家的编号获取所有相关的分仓
     * @param businessNo
     * @return
     */
    List<Business> listSubWarehouse(String businessNo);
}
