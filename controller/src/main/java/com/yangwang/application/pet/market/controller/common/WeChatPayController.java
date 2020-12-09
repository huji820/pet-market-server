package com.yangwang.application.pet.market.controller.common;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.RequestUtils;
import com.yangwang.application.pet.market.service.facade.business.BondFacedService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderFacedService;
import com.yangwang.application.pet.market.service.facade.common.PetOrderFacedService;
import com.yangwang.application.pet.market.service.facade.service.ServiceOrderService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LiuXiangLin
 * @version 1.0
 * @className WeChatPayController
 * @date 2019/10/29 14:59
 **/
@RestController
@Api(description = "微信支付")
@RequestMapping("/pay/weChat")
public class WeChatPayController {
    @Resource
    PetOrderFacedService petOrderFacedService;

    @Resource
    ItemOrderFacedService itemOrderFacedService;

    @Resource
    BondFacedService bondFacedService;

    @Resource
    ServiceOrderService serviceOrderService;

    /**
     * 获取宠粮订单的支付参数
     *
     * @param orderNo 订单编号
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author LiuXiangLin
     * @date 15:02 2019/10/29
     **/
    @GetMapping("/item")
    @ApiOperation(value = "获取宠粮订单的支付参数")
    public JsonResult getItemOrderPayParam(@RequestParam("orderNo") String orderNo, HttpServletRequest request) {
        Map<String, String> payParam = null;
        try {
            payParam = itemOrderFacedService.getPayParam(orderNo, RequestUtils.getAddress(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payParam == null ?
                JsonResult.err(RespondCodeEnum.UNKNOWN_ERROR.getCode(), "获取支付参数失败！")
                : JsonResult.success(payParam);
    }

    @GetMapping("/pet")
    @ApiOperation(value = "获取宠物订单支付参数")
    public JsonResult getPetPayParam(String orderNo, HttpServletRequest request) {
        Map<String, String> payParam = null;
        try {
            payParam = petOrderFacedService.getPayParam(orderNo, RequestUtils.getAddress(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payParam == null
                ? JsonResult.err(RespondCodeEnum.UNKNOWN_ERROR.getCode(), "获取支付参数失败！")
                : JsonResult.success(payParam);
    }

    @GetMapping("/bond")
    @ApiOperation(value = "获取保证金支付参数")
    public JsonResult getBondPayParam(String businessNo, HttpServletRequest request) {
        Map<String, String> payParam = null;
        try {
            payParam = bondFacedService.getBondPayParam(businessNo, RequestUtils.getAddress(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payParam == null
                ? JsonResult.err(RespondCodeEnum.UNKNOWN_ERROR.getCode(), "获取支付参数失败！")
                : JsonResult.success(payParam);
    }

    @GetMapping("/service")
    @ApiOperation(value = "获取服务支付参数")
    public JsonResult getServicePayParam(String orderNo, HttpServletRequest request) {
        Map<String, String> resultMap = null;

        try {
            resultMap = serviceOrderService.getPayParam(orderNo, RequestUtils.getAddress(request));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap == null ? JsonResult.err(RespondCodeEnum.UNKNOWN_ERROR.getCode(), "获取支付参数失败") : JsonResult.success(resultMap);
    }
}
