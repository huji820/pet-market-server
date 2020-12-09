package com.yangwang.application.pet.market.service.spring.task;

import com.yangwang.application.pet.market.service.facade.common.ItemOrderFacedService;
import com.yangwang.application.pet.market.service.facade.common.PetOrderFacedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 订单定时任务
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className OrderTask
 * @date 2020/4/26 11:38
 **/
@Component
@Configuration
@EnableScheduling
public class OrderTask {
    @Autowired
    ItemOrderFacedService itemOrderFacedService;

    @Autowired
    PetOrderFacedService petOrderFacedService;

    /**
     * <p>
     * 取消超过24小时未支付的订单
     * </p>
     *
     * @param
     * @return void
     * @author LiuXiangLin
     * @date 11:39 2020/4/26
     **/
    @Scheduled(cron = "0 0/18 * * * ?")
    public void cancelOrder() {
        itemOrderFacedService.cancelUnpaidOrder();
        petOrderFacedService.cancelUnpaidOrder();
    }
}
