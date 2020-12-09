package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.dao.business.BondMapper;
import com.yangwang.application.pet.market.model.business.Bond;
import com.yangwang.application.pet.market.service.service.BondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商家保证金
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:57 2020/3/24
 **/
@Service
public class BondServiceImpl implements BondService {
    @Resource
    BondMapper bondMapper;

    @Override
    public int save(Bond bond) {
        return bondMapper.save(bond);
    }

    @Override
    public int updateState(String bondNo, int state) {
        return bondMapper.updateState(bondNo, state);
    }

    @Override
    public Bond get(String bondNo) {
        return bondMapper.get(bondNo);
    }

    @Override
    public Bond getByBusinessNo(String businessNo) {
        return bondMapper.getByBusinessNo(businessNo);
    }
}
