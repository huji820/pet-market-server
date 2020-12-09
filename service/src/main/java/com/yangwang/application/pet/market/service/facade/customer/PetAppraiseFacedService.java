package com.yangwang.application.pet.market.service.facade.customer;

import com.yangwang.application.pet.market.model.vo.PetAppraiseVo;

/**
 * <p>
 * 宠物评价门面模式
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetAppraiseFacedService
 * @date 2020/3/23 10:53
 **/
public interface PetAppraiseFacedService {
    /**
     * <p>
     * 添加评论
     * </p>
     *
     * @param petAppraiseVo 宠物评论
     * @return int
     * @author LiuXiangLin
     * @date 10:53 2020/3/23
     **/
    int addAppraise(PetAppraiseVo petAppraiseVo);

    /**
     * <p>
     * 删除评论
     * </p>
     *
     * @param petAppraiseNo 评论主键
     * @return int
     * @author LiuXiangLin
     * @date 10:54 2020/3/23
     **/
    int deleteAppraise(int petAppraiseNo);
}
