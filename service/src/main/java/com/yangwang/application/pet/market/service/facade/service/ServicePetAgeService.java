package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.service.ServiceCatPrice;
import com.yangwang.application.pet.market.model.service.ServicePrice;

import java.util.List;

public interface ServicePetAgeService {

    List<ServiceCatPrice> listServicePetAge(long serviceID);
}

