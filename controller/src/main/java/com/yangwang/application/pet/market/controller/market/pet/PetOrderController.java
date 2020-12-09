package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetOrderFacedService;
import com.yangwang.application.pet.market.service.facade.customer.PetOrderService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * <p>
 * 宠物订单
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:54 2020/3/28
 **/
@Api(description = "宠物订单")
@RestController
@RequestMapping("/api/order/pet")
public class PetOrderController {
    @Resource
    PetOrderFacedService petOrderFacedService;

    @Resource
    PetOrderService petOrderService;

    @PostMapping()
    @ApiOperation(value = "新增订单")
    public JsonResult save(@RequestBody PetOrderVo petOrderVo) {
        if (!checkParam(petOrderVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        long petOrderNo = petOrderFacedService.save(petOrderVo);

        return petOrderNo > 0 ? JsonResult.success(petOrderNo) : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "新增失败！");
    }

    @PostMapping("/price")
    @ApiOperation(value = "获取宠物价格")
    public JsonResult getOrderPrice(@RequestBody PetOrderVo petOrderVo) {
        if (!checkParam(petOrderVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(petOrderFacedService.getPrice(petOrderVo));
    }

    @PutMapping("/sign-for/{orderNo:\\w+}")
    @ApiOperation(value = "签收订单")
    public JsonResult signForOrder(@PathVariable String orderNo) {
        return petOrderFacedService.signFor(orderNo) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "签收失败！");
    }

    @PutMapping("/deliver/{orderNo:\\w+}/way-bill/{wayBill:\\w+}")
    @ApiOperation(value = "订单发货")
    public JsonResult deliverOrder(@PathVariable("orderNo") String orderNo,
                                   @PathVariable("wayBill") String wayBill
    ) {
        return petOrderFacedService.deliverOrder(orderNo, wayBill) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "发货失败！");
    }

    @GetMapping("/{orderNo:\\w+}")
    @ApiOperation(value = "获取订单")
    public JsonResult get(@PathVariable String orderNo) {
        return JsonResult.success(petOrderService.get(orderNo));
    }

    @GetMapping("/getPaymentAmount")
    @ApiOperation(value = "获取订单最新金额")
    public JsonResult getPaymentAmount(@Param("paymentAmount")BigDecimal paymentAmount,@Param("consignOrderNo")String consignOrderNo){
        return JsonResult.success(petOrderFacedService.getPaymentAmounts(paymentAmount,consignOrderNo));
    }

    @ApiOperation("修改订单价格")
    @PostMapping("/updateOrderPrice")
    public JsonResult updateOrderPrice(@RequestParam("orderNo")String orderNo,
                                       @RequestParam("price")BigDecimal price){
        return JsonResult.success(petOrderFacedService.updateOrderPrice(orderNo, price));
    }

    @ApiOperation(value = "添加支付凭证")
    @PostMapping("/uploadPaymentVoucher")
    public JsonResult uploadPaymentVoucher(@RequestParam("orderNo")String orderNo,@RequestParam("paymentVoucher")String paymentVoucher){
        return JsonResult.success(petOrderFacedService.uploadPaymentVoucher(orderNo, paymentVoucher));
    }

    private boolean checkParam(PetOrderVo petOrderVo) {
        return petOrderVo != null
                && petOrderVo.getPet() != null
                && petOrderVo.getPet().getPetNo() != null
                && petOrderVo.getBusiness() != null
                && petOrderVo.getBusiness().getBusinessNo() != null
                && petOrderVo.getQty() != null
                && petOrderVo.getQty() > 0
                && petOrderVo.getReceivingAddress() != null;
    }
}
