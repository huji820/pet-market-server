package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.vo.ItemOrderVo;
import com.yangwang.application.pet.market.service.facade.common.CouponItemService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 商品折扣
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponItemDiscountServiceImpl
 * @date 2020/3/28 14:22
 **/
@Component
public class CouponItemDiscountServiceImpl implements CouponItemService {

    @Resource
    ItemOrderFacedServiceImpl ItemOrderFacedServiceImpl;

    @Override
    public BigDecimal calcDisCount(ItemOrderVo itemOrderVo) {

        ItemOrder itemOrder = ItemOrderFacedServiceImpl.convertToItemOrder(itemOrderVo);
        if (checkBusiness(itemOrderVo) && checkLeast(itemOrder) && checkItem(itemOrder)) {
            return itemOrder.getOriginalAmount()
                    .subtract((itemOrder.getOriginalAmount().multiply(BigDecimal.valueOf(itemOrderVo.getCoupon().getCouponType().getDiscount())))
                            .divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP, 2));

        }
        return null;
    }
}
