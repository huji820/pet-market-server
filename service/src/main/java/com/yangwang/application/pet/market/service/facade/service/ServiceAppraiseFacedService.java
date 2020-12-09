package com.yangwang.application.pet.market.service.facade.service;

import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.model.vo.ServiceAppraiseVo;

/**
 * <p>
 * 服务评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseFacedService
 * @date 2020/3/24 9:39
 **/
public interface ServiceAppraiseFacedService {
    /**
     * <p>
     * 添加商品评价
     * </p>
     *
     * @param serviceAppraiseVo 服务评价Vo对象
     * @return int
     * @author LiuXiangLin
     * @date 9:39 2020/3/24
     **/
    int addAppraise(ServiceAppraiseVo serviceAppraiseVo);

    /**
     * <p>
     * 删除一条服务评价
     * </p>
     *
     * @param serviceAppraiseNo 服务评价编号
     * @return int
     * @author LiuXiangLin
     * @date 9:40 2020/3/24
     **/
    int deleteAppraise(int serviceAppraiseNo);
}
