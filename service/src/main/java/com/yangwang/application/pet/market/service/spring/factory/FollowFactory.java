package com.yangwang.application.pet.market.service.spring.factory;

import com.yangwang.application.pet.market.model.business.Follow;
import com.yangwang.application.pet.market.service.service.BaseFollowService;
import com.yangwang.application.pet.market.service.spring.common.BusinessFollowServiceImpl;
import com.yangwang.application.pet.market.service.spring.common.ItemFollowServiceImpl;
import com.yangwang.application.pet.market.service.spring.common.PetFollowServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 关注service工厂
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FollowFactory
 * @date 2020/3/21 10:23
 **/
@Component
public class FollowFactory {
    @Resource
    BusinessFollowServiceImpl businessFollowService;

    @Resource
    ItemFollowServiceImpl itemFollowService;

    @Resource
    PetFollowServiceImpl petFollowService;

    /**
     * <p>
     * 获取service
     * </p>
     *
     * @param followType 关注类型
     * @return com.yangwang.application.pet.market.service.service.BaseFollowService
     * @author LiuXiangLin
     * @date 13:59 2020/3/21
     **/
    public BaseFollowService getFollowService(int followType) {
        BaseFollowService result;
        switch (followType) {
            case Follow.TYPE_BUSINESS:
                result = businessFollowService;
                break;
            case Follow.TYPE_PET:
                result = petFollowService;
                break;
            case Follow.TYPE_ITEM:
                result = itemFollowService;
                break;
            default:
                result = null;
        }
        return result;
    }
}
