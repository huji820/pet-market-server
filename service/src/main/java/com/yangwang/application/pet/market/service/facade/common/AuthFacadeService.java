package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.vo.AuthVo;

/**
 * <p>
 * 商家认证门面模式
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className AuthFacadeService
 * @date 2020/3/19 14:44
 **/
public interface AuthFacadeService {
    /**
     * <p>
     * 新增商家认证
     * </p>
     *
     * @param authVo 认证DTO
     * @return int
     * @author LiuXiangLin
     * @date 14:44 2020/3/19
     **/
    int save(AuthVo authVo);
}
