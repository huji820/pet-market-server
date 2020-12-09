package com.yangwang.application.pet.market.service.facade.pay;

/**
 * 支付成功后的策略
 * @Description
 * @Author hj
 * @Date 2020-03-30 2:13
 * @Version 1.0
 */
public interface PayCallbackStrategy {

    /**
     * 回调
     * @param billNo
     * @return
     */
    int request(String billNo);
}
