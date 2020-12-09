package com.yangwang.application.pet.market.service.spring.pay;

import com.yangwang.application.pet.market.model.market.ServiceOrder;
import com.yangwang.application.pet.market.service.facade.pay.PayCallbackStrategy;
import com.yangwang.application.pet.market.service.facade.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-30 2:14
 * @Version 1.0
 */
@Service
public class ServiceOrderPayStratrgy implements PayCallbackStrategy {

    @Autowired
    ServiceOrderService serviceOrderService;

    @Override
    public int request(String billNo) {
        ServiceOrder serviceOrder = serviceOrderService.getServiceOrder(billNo);

        serviceOrder.setPaymentState(1);

        serviceOrderService.updateServicePayment(serviceOrder);

        return 1;
    }
}
