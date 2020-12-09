package com.yangwang.application.pet.market.service.facade.common;

import com.yangwang.application.pet.market.model.common.BaseUnifiedPay;

import java.util.Map;

/**
 * <p>
 * 统一支付
 * </p>
 *
 * @author HuJi
 * @date 10:06 2020/3/26
 **/
public interface AccountService {


    /**
     * 统一支付接口
     *
     * @return
     */
    Map<String, String> unifiedPay(BaseUnifiedPay pay) throws Exception;

    /**
     * 回调
     *
     * @param pay 统一支付参数
     * @return
     */
    int unifiedOrder(BaseUnifiedPay pay) throws Exception;

    /** 
     * 宠物订单回调
     * 
     * @param pay 统一支付参数
     * @return void
     * @author HuZhengYu
     * @date 15:28 2020/9/29
     */
    void petOrder(BaseUnifiedPay pay) throws Exception;
}
