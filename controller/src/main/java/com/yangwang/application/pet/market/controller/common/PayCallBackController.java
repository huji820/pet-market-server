package com.yangwang.application.pet.market.controller.common;

import com.yangwang.application.pet.market.service.facade.business.BondFacedService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderFacedService;
import com.yangwang.application.pet.market.service.facade.common.PetOrderFacedService;
import com.yangwang.application.pet.market.service.facade.service.ServiceOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 支付回调地址
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PayCallBackController
 * @date 2019/10/29 9:54
 **/
@RestController
@RequestMapping(value = "/api/market/pay/callback")
@Api(description = "微信回调地址")
public class PayCallBackController {
    @Resource
    PetOrderFacedService petOrderFacedService;

    @Resource
    ItemOrderFacedService itemOrderFacedService;

    @Resource
    BondFacedService bondFacedService;

    @Resource
    ServiceOrderService serviceOrderService;

    private static final String WE_CHAT_SUCCESS_CALL_BACK_RETURN =
            "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付回调已收到]]></return_msg></xml>";

    /**
     * 购买宠粮回调地址
     *
     * @param orderNo 订单编号
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 9:56 2019/10/29
     **/
    @ApiOperation(value = "购买宠粮回调")
    @RequestMapping("/item/order/{orderNo:[\\w]+}")
    public String payBuyItemCallBack(@PathVariable("orderNo") String orderNo) throws Exception {
        System.err.printf("购买宠粮回调");
        itemOrderFacedService.payCallBack(orderNo);
        return WE_CHAT_SUCCESS_CALL_BACK_RETURN;
    }

    @ApiOperation(value = "购买宠物回调地址")
    @RequestMapping("/pet/order/{orderNo:[\\w]+}")
    public String payBuyPetCallBack(@PathVariable("orderNo") String orderNo) throws Exception {
        System.err.printf("购买宠物回调地址");
        petOrderFacedService.payCallBack(orderNo);
        return WE_CHAT_SUCCESS_CALL_BACK_RETURN;
    }


    @ApiOperation(value = "保证金回调")
    @RequestMapping("/bond/{billNo:[\\w]+}")
    public String payBuyBondCallBack(@PathVariable("billNo") String billNo) {
        System.err.printf("购买宠物回调地址");
        bondFacedService.payCallBack(billNo);
        return WE_CHAT_SUCCESS_CALL_BACK_RETURN;
    }

    @ApiOperation(value = "服务订单回调")
    @RequestMapping("/service/{orderNo:\\w+}")
    public String payServiceOrderCallBack(@PathVariable("orderNo") String orderNo) {
        System.err.printf("购买宠物回调地址");
        serviceOrderService.payCallBack(orderNo);
        return WE_CHAT_SUCCESS_CALL_BACK_RETURN;
    }


}
