package com.yangwang.application.pet.market.controller.customer;

import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import com.yangwang.application.pet.market.service.facade.common.PetOrderListService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 买家宠物订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CustomerPetOrderController
 * @date 2020/3/31 15:58
 **/
@RestController
@Api(description = "买家宠物订单列表")
@RequestMapping("/api/customer/pet/order")
public class CustomerPetOrderController {
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

        return JsonResult.success(petOrderListService.listBuyerOrderByParam(queryOrderListParam));
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

        return JsonResult.success(petOrderListService.listBuyerOrderByParam(queryOrderListParam));
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

        return JsonResult.success(petOrderListService.listBuyerOrderByParam(queryOrderListParam));
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

        return JsonResult.success(petOrderListService.listBuyerOrderByParam(queryOrderListParam));
    }
    @ApiOperation(value = "通过宠物的订单号删除宠物的未支付订单")
    @PostMapping("/delPetOrderByNO")
    public JsonResult delPetOrderByNO(@RequestParam("orderNo") String orderNo,@RequestParam("buyer_customer_no")String buyercustomerno,@RequestParam("way_bill")String waybill){
        return JsonResult.success(petOrderListService.delPetOrderByNO(orderNo,buyercustomerno,waybill));
    }
}
