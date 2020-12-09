package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.model.market.ItemAppraise;
import com.yangwang.application.pet.market.model.vo.ItemAppraiseVo;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseFacedService;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseImgService;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseService;
import com.yangwang.application.pet.market.service.facade.customer.ItemFavorableRateService;
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
public class ItemAppraiseFacedServiceImpl implements ItemAppraiseFacedService {
    @Resource
    ItemAppraiseService itemAppraiseService;

    @Resource
    ItemAppraiseImgService itemAppraiseImgService;

    @Resource
    ItemService itemService;

    @Resource
    ItemFavorableRateService itemFavorableRateService;

    @Resource
    ItemOrderService itemOrderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addAppraise(ItemAppraiseVo itemAppraiseVo) {
        // 获取评价列表
        if (itemAppraiseService.getByAppraise(itemAppraiseVo.getItemAppraise()) == null) {
            // 商品评价数量 + 1
            itemService.updateEvaluationAdd(itemAppraiseVo.getItemAppraise().getItem().getItemNo(), 1);

            // 计算并保存商品好评率
            BigDecimal favorableRate = itemFavorableRateService.calcFavorableRate(itemAppraiseVo.getItemAppraise().getItem().getItemNo());
            itemService.updateFavorableRate(itemAppraiseVo.getItemAppraise().getItem().getItemNo(), favorableRate);

            // 插入商品评价
            itemAppraiseService.save(itemAppraiseVo.getItemAppraise());

            // 插入商品评价图片
            itemAppraiseImgService.save(itemAppraiseVo.addAppraiseToList().getItemAppraiseImgList());

            // 回写订单评论
            itemOrderService.updateEvaluateState(itemAppraiseVo.getItemAppraise().getItemOrder().getOrderNo(), OrderStateEnum.EVALUATE_EVALUATED.getState());

            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteAppraise(int itemAppraiseNo) {
        // 获取评价列表
        ItemAppraise itemAppraise = itemAppraiseService.get(itemAppraiseNo);
        if (itemAppraise != null) {
            // 商品评价数量 - 1
            itemService.updateEvaluationSub(itemAppraiseNo, 1);

            // 计算并保存商品好评率
            BigDecimal favorableRate = itemFavorableRateService.calcFavorableRate(itemAppraise.getItem().getItemNo());
            itemService.updateFavorableRate(itemAppraise.getItem().getItemNo(), favorableRate);

            // 删除商品评价
            itemAppraiseService.delete(itemAppraiseNo);

            // 删除商品的评价图片
            itemAppraiseImgService.deleteByAppraiseNo(itemAppraiseNo);

            return 1;
        }

        return 0;
    }
}
