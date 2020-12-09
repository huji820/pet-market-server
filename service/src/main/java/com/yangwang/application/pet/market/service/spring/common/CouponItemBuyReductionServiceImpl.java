package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.vo.ItemOrderVo;
import com.yangwang.application.pet.market.service.facade.common.CouponItemService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 商品满减
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponItemBuyReductionServiceImpl
 * @date 2020/3/28 14:21
 **/
@Component
public class CouponItemBuyReductionServiceImpl implements CouponItemService {

    @Resource
    ItemOrderFacedServiceImpl ItemOrderFacedServiceImpl;

    @Override
    public BigDecimal calcDisCount(ItemOrderVo itemOrderVo) {

        ItemOrder itemOrder = ItemOrderFacedServiceImpl.convertToItemOrder(itemOrderVo);
        if (checkBusiness(itemOrderVo) && checkLeast(itemOrder) && checkItem(itemOrder)) {
            return itemOrderVo.getCoupon().getCouponType().getValue().compareTo(itemOrder.getOriginalAmount()) >= 0
                    ? itemOrder.getOriginalAmount()
                    : itemOrderVo.getCoupon().getCouponType().getValue();
        }

        return null;
    }
}
