package com.yangwang.application.pet.market.controller.customer;

import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import com.yangwang.application.pet.market.service.facade.common.PetOrderListService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商家宠物订单列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BusinessPetOrderController
 * @date 2020/4/1 9:55
 **/
@RestController
@RequestMapping("/api/business/pet/order")
@Api(description = "商家宠物订单列表")
public class BusinessPetOrderController {
    @Resource
    PetOrderListService petOrderListService;

    @GetMapping("/non-payment")
    @ApiOperation(value = "未支付订单")
    public JsonResult list(@RequestParam("businessNo") String businessNo,
                           @RequestParam("offset") int offset,
                           @RequestParam("limit") int limit) {
        QueryOrderListParam queryOrderListParam = QueryOrderListParam.getNonPayment();
        queryOrderListParam.setBuyerNo(businessNo);
        queryOrderListParam.setOffset(offset);
        queryOrderListParam.setLimit(limit);
        queryOrderListParam.dealWithParam();

        return JsonResult.success(petOrderListService.listShopOrderByParam(queryOrderListParam));
    }

    @GetMapping("/to-be-delivered")
    @ApiOperation(value = "待发货订单")
    public JsonResult getToBeDelivered(@RequestParam("businessNo") String businessNo,
                                       @RequestParam("offset") int offset,
                                       @RequestParam("limit") int limit) {
        QueryOrderListParam queryOrderListParam = QueryOrderListParam.getToBeDelivered();
        queryOrderListParam.setBuyerNo(businessNo);
        queryOrderListParam.setOffset(offset);
        queryOrderListParam.setLimit(limit);
        queryOrderListParam.dealWithParam();

        return JsonResult.success(petOrderListService.listShopOrderByParam(queryOrderListParam));
    }

    @GetMapping("/to-be-received")
    @ApiOperation(value = "待收货订单")
    public JsonResult getToBeReceived(@RequestParam("businessNo") String businessNo,
                                      @RequestParam("offset") int offset,
                                      @RequestParam("limit") int limit) {
        QueryOrderListParam queryOrderListParam = QueryOrderListParam.getToBeReceived();
        queryOrderListParam.setBuyerNo(businessNo);
        queryOrderListParam.setOffset(offset);
        queryOrderListParam.setLimit(limit);
        queryOrderListParam.dealWithParam();

        return JsonResult.success(petOrderListService.listShopOrderByParam(queryOrderListParam));
    }

    @GetMapping("/to-be-evaluated")
    @ApiOperation(value = "待评价订单")
    public JsonResult getToBeEvaluated(@RequestParam("businessNo") String businessNo,
                                       @RequestParam("offset") int offset,
                                       @RequestParam("limit") int limit) {
        QueryOrderListParam queryOrderListParam = QueryOrderListParam.getToBeEvaluated();
        queryOrderListParam.setBuyerNo(businessNo);
        queryOrderListParam.setOffset(offset);
        queryOrderListParam.setLimit(limit);
        queryOrderListParam.dealWithParam();

        return JsonResult.success(petOrderListService.listShopOrderByParam(queryOrderListParam));
    }
}
