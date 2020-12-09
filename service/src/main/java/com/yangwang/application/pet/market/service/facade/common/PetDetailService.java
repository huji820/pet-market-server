package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.vo.PetVo;

/**
 * <p>
 * 宠物明细
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:05 2020/3/18
 **/
public interface PetDetailService {
    /**
     * <p>
     * 通过宠物编号查询宠物明细
     * </p>
     *
     * @param petNo 宠物编号
     * @return com.yangwang.application.pet.market.model.vo.PetVo
     * @author LiuXiangLin
     * @date 9:08 2020/3/18
     **/
    PetVo get(String petNo);
}
