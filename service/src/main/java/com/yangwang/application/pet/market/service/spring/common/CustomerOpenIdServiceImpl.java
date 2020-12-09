package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.AppTypeEnum;
import com.yangwang.application.pet.market.dao.common.CustomerOpenIdMapper;
import com.yangwang.application.pet.market.model.common.CustomerOpenId;
import com.yangwang.application.pet.market.service.facade.common.CustomerOpenIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CustomerOpenIdServiceImpl
 * @date 2020/3/4 10:31
 **/
@Service
public class CustomerOpenIdServiceImpl implements CustomerOpenIdService {
    @Resource
    CustomerOpenIdMapper customerOpenIdMapper;

    @Override
    public CustomerOpenId getByCustomerNoAndType(String customerNo, AppTypeEnum appTypeEnum) {
        return customerOpenIdMapper.getByCustomerNoAndType(customerNo, appTypeEnum.getType());
    }

    @Override
    public int saveOrUpdate(CustomerOpenId customerOpenId) {
        return customerOpenIdMapper.saveOrUpdate(customerOpenId);
    }
}
