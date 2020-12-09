package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.service.ServicePrice;

import java.util.List;
public interface ServicePetWeightService {

    List<ServicePrice> listServicePetWeight(long serviceID, int hairLength);
}

