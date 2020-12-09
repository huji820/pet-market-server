package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.MyPet;

import java.util.List;

/**
 * <p>
 * 我的爱宠
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MyPetService
 * @date 2020/3/24 17:46
 **/
public interface MyPetService {
    /**
     * <p>
     * 新增一只宠物
     * </p>
     *
     * @param myPet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 17:48 2020/3/24
     **/
    int save(MyPet myPet);

    /**
     * <p>
     * 编辑宠物
     * </p>
     *
     * @param myPet 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 17:48 2020/3/24
     **/
    int update(MyPet myPet);

    /**
     * <p>
     * 通过宠物编号获取宠物
     * </p>
     *
     * @param petNo 宠物编号
     * @return com.yangwang.application.pet.market.model.common.MyPet
     * @author LiuXiangLin
     * @date 17:48 2020/3/24
     **/
    MyPet get(int petNo);

    /**
     * <p>
     * 删除宠物
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 17:49 2020/3/24
     **/
    int delete(int petNo);

    /**
     * <p>
     * 通过商家编查询所有的爱宠
     * </p>
     *
     * @param businessNo 商家编号
     * @return java.util.List<com.yangwang.application.pet.market.model.common.MyPet>
     * @author LiuXiangLin
     * @date 17:49 2020/3/24
     **/
    List<MyPet> listByBusinessNo(String businessNo);

    /**
     * <p>
     * 通过用户编号查询总数
     * </p>
     *
     * @param businessNo 商家编号
     * @return int
     * @author LiuXiangLin
     * @date 10:40 2020/4/30
     **/
    int countByBusinessNo(String businessNo);
}
