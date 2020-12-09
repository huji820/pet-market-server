package com.yangwang.application.pet.market.service.facade.common;


import com.yangwang.application.pet.market.model.vo.PetVo;

/**
 * <p>
 * 宠物上架
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetPutOnSaleService
 * @date 2020/3/13 9:33
 **/
public interface PetPutOnSaleService {
    /**
     * <p>
     * 宠物上架
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 9:35 2020/3/13
     **/
    int putOnSale(String petNo);

    /**
     * <p>
     * 宠物下架
     * </p>
     *
     * @param petNo 宠物编号
     * @return int
     * @author LiuXiangLin
     * @date 9:35 2020/3/13
     **/
    int pullOffShelves(String petNo);

    /**
     * <p>
     * 新增宠物上架
     * </p>
     *
     * @param petVo 宠物VO对象
     * @return int
     * @author LiuXiangLin
     * @date 9:36 2020/3/13
     **/
    int newPutOnSale(PetVo petVo);

    /**
     * <p>
     * 发布修改
     * </p>
     *
     * @param petVo 宠物对象
     * @return int
     * @author LiuXiangLin
     * @date 16:39 2020/3/22
     **/
    int update(PetVo petVo);

}
