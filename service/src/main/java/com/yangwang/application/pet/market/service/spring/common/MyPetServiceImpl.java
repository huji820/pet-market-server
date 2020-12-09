package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.common.MyPetMapper;
import com.yangwang.application.pet.market.model.common.MyPet;
import com.yangwang.application.pet.market.service.facade.common.MyPetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MyPetServiceImpl
 * @date 2020/3/24 17:49
 **/
@Service
public class MyPetServiceImpl implements MyPetService {
    @Resource
    MyPetMapper myPetMapper;

    @Override
    public int save(MyPet myPet) {
        return myPetMapper.save(myPet);
    }

    @Override
    public MyPet get(int petNo) {
        return myPetMapper.get(petNo);
    }

    @Override
    public int update(MyPet myPet) {
        return myPetMapper.update(myPet);
    }

    @Override
    public int delete(int petNo) {
        return myPetMapper.delete(petNo);
    }

    @Override
    public List<MyPet> listByBusinessNo(String businessNo) {
        return myPetMapper.listByBusinessNo(businessNo);
    }

    @Override
    public int countByBusinessNo(String businessNo) {
        return myPetMapper.countByBusinessNo(businessNo);
    }
}
