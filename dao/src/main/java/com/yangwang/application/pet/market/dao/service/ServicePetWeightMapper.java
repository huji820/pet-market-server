package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.service.ServicePrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务重量
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:19 2020/4/2
 **/
@Mapper
public interface ServicePetWeightMapper {

    List<ServicePrice> listServicePetWeight(@Param("serviceID") long serviceID, @Param("hairLength") int hairLength);
}
