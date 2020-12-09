package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.dao.business.BusinessPowerMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.facade.business.BusinessPowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 * 商家权重
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessPowerServiceImpl
 * @date 2020/3/17 15:16
 **/
@Service
public class BusinessPowerServiceImpl implements BusinessPowerService {
    @Resource
    BusinessPowerMapper businessPowerMapper;

    @Override
    public int get(Business business) {
        /*目前只已是否缴纳保证金为基准*/
        return business.getPayBond();
    }

    @Override
    public int update(String businessNo, int power) {
        return businessPowerMapper.update(businessNo, power);
    }
}
