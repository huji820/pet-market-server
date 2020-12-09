package com.yangwang.application.pet.market.dao.service;

import com.yangwang.application.pet.market.model.service.ServiceCatPrice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 服务年龄
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:18 2020/4/2
 **/
@Mapper
public interface ServicePetAgeMapper {

    List<ServiceCatPrice> listServicePetAge(long serviceID);
}

