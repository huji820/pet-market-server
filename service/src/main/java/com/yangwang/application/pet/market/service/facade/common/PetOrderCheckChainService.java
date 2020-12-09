package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.market.PetOrderVo;

/**
 * <p>
 * 宠物订单责任链
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderCheckChainService
 * @date 2020/3/28 10:18
 **/
public interface PetOrderCheckChainService {
    /**
     * <p>
     * 校验
     * </p>
     *
     * @param petOrderVo 宠物订单Vo
     * @author LiuXiangLin
     * @date 10:19 2020/3/28
     **/
    void check(PetOrderVo petOrderVo);


    /**
     * <p>
     * 设置下一个节点
     * </p>
     *
     * @param petOrderCheckChainService 下一个节点
     * @author LiuXiangLin
     * @date 10:49 2020/3/28
     **/
    void setNext(PetOrderCheckChainService petOrderCheckChainService);

}
