package com.yangwang.application.pet.market.service.service;

import com.yangwang.application.pet.market.model.business.Auth;

/***
 * <p>
 * 商家认证
 * </p>
 *
 * @author LiuXiangLin
 * @date 16:44 2020/3/14
 **/
public interface AuthService {
    /**
     * <p>
     * 保存一条数据
     * </p>
     *
     * @param auth 商家认证对象
     * @return int
     * @author LiuXiangLin
     * @date 16:44 2020/3/14
     **/
    int save(Auth auth);

    /**
     * <p>
     * 通过商家编号删除商家认证
     * </p>
     *
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 16:45 2020/3/14
     **/
    int delete(String businessNo);

    /**
     * <p>
     * 更新商家认证
     * </p>
     *
     * @param auth 商家认证对象
     * @return int
     * @author LiuXiangLin
     * @date 16:45 2020/3/14
     **/
    int update(Auth auth);

    /**
     * <p>
     * 通过商家编号查认证
     * </p>
     *
     * @param businessNo 商家编号
     * @return com.yangwang.application.pet.market.model.business.Auth
     * @author LiuXiangLin
     * @date 16:46 2020/3/14
     **/
    Auth getByBusinessNo(String businessNo);

    /**
     * <p>
     * 新增或者更新
     * </p>
     *
     * @param auth 商家对象
     * @return int
     * @author LiuXiangLin
     * @date 18:29 2020/3/19
     **/
    int saveOrUpdate(Auth auth);

}
