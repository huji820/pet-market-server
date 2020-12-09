package com.yangwang.application.pet.market.controller.customer;

import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderListServer;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户商品订单
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:23 2020/4/1
 **/
@RestController
@RequestMapping("/api/customer/item/order")
@Api(description = "买家商品订单列表")
public class CustomerItemOrderController {
    @Resource
    ItemOrderListServer itemOrderListServer;


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

        return JsonResult.success(itemOrderListServer.listBuyerOrderByParam(queryOrderListParam));
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

        return JsonResult.success(itemOrderListServer.listBuyerOrderByParam(queryOrderListParam));
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

        return JsonResult.success(itemOrderListServer.listBuyerOrderByParam(queryOrderListParam));
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

        return JsonResult.success(itemOrderListServer.listBuyerOrderByParam(queryOrderListParam));
    }

    @ApiOperation(value = "通过商城订单号删除商品的未支付订单")
    @PostMapping("/deleteItemOrderByNo")
    public JsonResult delToBeEvaluated(@RequestParam("orderNo") String orderNo){
        return JsonResult.success(itemOrderListServer.delOrderByNo(orderNo));
    }
}
