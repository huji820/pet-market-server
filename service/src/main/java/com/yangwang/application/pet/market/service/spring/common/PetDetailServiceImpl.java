package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetDetailMapper;

import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.PetDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:35 2020/3/18
 **/
@Service
public class PetDetailServiceImpl implements PetDetailService {
    @Resource
    PetDetailMapper petDetailMapper;

    @Override
    public PetVo get(String petNo) {
        return petDetailMapper.get(petNo);
    }
}
