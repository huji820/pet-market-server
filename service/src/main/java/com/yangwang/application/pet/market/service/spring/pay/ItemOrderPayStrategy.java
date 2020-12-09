package com.yangwang.application.pet.market.service.spring.pay;

import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderService;
import com.yangwang.application.pet.market.service.facade.pay.PayCallbackStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderPayStrategy
 * @date 2020/4/1 11:56
 **/
@Service
public class ItemOrderPayStrategy implements PayCallbackStrategy {
    @Resource
    ItemOrderService itemOrderService;

    @Override
    public int request(String billNo) {
        // 获取订单
        ItemOrder itemOrder = itemOrderService.get(billNo);

        // 校验支付状态
        if (OrderStateEnum.PAY_UNPAID.getState() == itemOrder.getPaymentState()) {
            // 回写订单状态
            itemOrderService.updatePaymentState(billNo, OrderStateEnum.PAY_PAID.getState());
        } else {
            throw new RuntimeException("该订单已经支付");
        }

        return 0;
    }
}
