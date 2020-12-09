package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.model.market.ItemAppraise;
import com.yangwang.application.pet.market.model.market.ServiceOrder;
import com.yangwang.application.pet.market.model.service.ServiceAppraise;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.model.vo.ServiceAppraiseVo;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseFacedService;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseImgService;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseService;
import com.yangwang.application.pet.market.service.facade.customer.ItemFavorableRateService;
import com.yangwang.application.pet.market.service.facade.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseFacedServiceImpl
 * @date 2020/3/24 9:41
 **/
@Service
public class ServiceAppraiseFacedServiceImpl implements ServiceAppraiseFacedService {

    @Resource
    ServiceAppraiseService serviceAppraiseService;

    @Resource
    ServiceAppraiseImgService serviceAppraiseImgService;

    @Resource
    ServiceInfoService serviceInfoService;

    @Resource
    ItemFavorableRateService itemFavorableRateService;

    @Resource
    ServiceOrderService serviceOrderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addAppraise(ServiceAppraiseVo serviceAppraiseVo) {
        // 获取评价列表
        if (serviceAppraiseService.getByAppraise(serviceAppraiseVo.getServiceAppraise()) == null) {
            // 商品评价数量 + 1
            //itemService.updateEvaluationAdd(serviceAppraiseVo.getServiceAppraise().getService().getServiceID(), 1);

            // 计算并保存商品好评率
            //BigDecimal favorableRate = itemFavorableRateService.calcFavorableRate(itemAppraiseVo.getItemAppraise().getItem().getItemNo());
            //itemService.updateFavorableRate(serviceAppraiseVo.getItemAppraise().getItem().getItemNo(), favorableRate);

            // 插入商品评价
            serviceAppraiseService.save(serviceAppraiseVo.getServiceAppraise());

            // 插入商品评价图片
            serviceAppraiseImgService.save(serviceAppraiseVo.addAppraiseToList().getServiceAppraiseImgList());

            // 回写订单评论
            //serviceOrderService.updateEvaluateState(serviceAppraiseVo.getItemAppraise().getItemOrder().getOrderNo(), OrderStateEnum.EVALUATE_EVALUATED.getState());

            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteAppraise(int itemAppraiseNo) {
        // 获取评价列表
        ServiceAppraise itemAppraise = serviceAppraiseService.get(itemAppraiseNo);
        if (itemAppraise != null) {
            // 商品评价数量 - 1
            //serviceInfoService.updateEvaluationSub(itemAppraiseNo, 1);

            // 计算并保存商品好评率
            //BigDecimal favorableRate = itemFavorableRateService.calcFavorableRate(itemAppraise.getItem().getItemNo());
            //itemService.updateFavorableRate(itemAppraise.getItem().getItemNo(), favorableRate);

            // 删除商品评价
            serviceAppraiseService.delete(itemAppraiseNo);

            // 删除商品的评价图片
            serviceAppraiseImgService.deleteByAppraiseNo(itemAppraiseNo);

            return 1;
        }

        return 0;
    }
}
