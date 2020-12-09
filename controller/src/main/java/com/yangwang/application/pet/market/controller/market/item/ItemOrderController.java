package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.vo.ItemOrderInfoVo;
import com.yangwang.application.pet.market.model.vo.ItemOrderVo;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderFacedService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 商品订单
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderController
 * @date 2020/4/1 8:50
 **/
@RestController
@RequestMapping("/api/order/item")
@Api(description = "商品订单")
public class ItemOrderController {
    @Resource
    ItemOrderFacedService itemOrderFacedService;

    @Resource
    ItemOrderService itemOrderService;

    @Resource
    BusinessService businessService;

    @PostMapping("")
    @ApiOperation(value = "新增订单")
    public JsonResult save(@RequestBody ItemOrderVo itemOrderVo) {
        if (!checkPrice(itemOrderVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        long orderNo = itemOrderFacedService.save(itemOrderVo);

        return orderNo > 0
                ? JsonResult.success(orderNo)
                : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "新增订单失败！");
    }

    @ApiOperation("修改订单价格")
    @PostMapping("/updateOrderPrice")
    public JsonResult updateOrderPrice(@RequestParam("orderNo")String orderNo, @RequestParam("price")BigDecimal price){
        int i = itemOrderFacedService.updateOrderPrice(orderNo, price);
        return i > 0?JsonResult.success() : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(),"修改价格失败");
    }

    @ApiOperation(value = "添加支付凭证")
    @PostMapping("/uploadPaymentVoucher")
    public JsonResult uploadPaymentVoucher(@RequestParam("orderNo")String orderNo,@RequestParam("paymentVoucher")String paymentVoucher){
        return JsonResult.success(itemOrderFacedService.uploadPaymentVoucher(orderNo, paymentVoucher));
    }

    @PostMapping("/price")
    @ApiOperation(value = "获取订单价格")
    public JsonResult getPrice(@RequestBody ItemOrderVo itemOrderVo) {
        if (!checkPrice(itemOrderVo)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        // 判断身份
        Business business = businessService.getByBusinessNoAndState(itemOrderVo.getBuyer().getBusinessNo(), 1);
        itemOrderVo.setBuyer(business);
        return JsonResult.success(itemOrderFacedService.getPrice(itemOrderVo));
    }

    @PutMapping("/sign-for/{orderNo:\\w+}")
    @ApiOperation(value = "签收订单")
    public JsonResult signForOrder(@PathVariable("orderNo") String orderNo) {
        return itemOrderFacedService.signForOrder(orderNo) > 0 ? JsonResult.success() : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "签收失败！");
    }

    @PutMapping("/deliver/{orderNo:\\w+}/way-bill/{wayBill:\\w+}/express/{expressCompany:\\w+}")
    @ApiOperation(value = "订单发货")
    public JsonResult deliverForOrder(@PathVariable String orderNo,
                                      @PathVariable String wayBill,
                                      @PathVariable String expressCompany) {
        return itemOrderFacedService.deliverForOrder(orderNo, wayBill, expressCompany) > 0
                ? JsonResult.success()
                : JsonResult.err(RespondCodeEnum.UPDATE_ERROR.getCode(), "发货失败！");
    }

    @GetMapping("/{orderNo:\\w+}")
    @ApiOperation(value = "获取订单")
    public JsonResult get(@PathVariable String orderNo) {
        return JsonResult.success(itemOrderService.get(orderNo));
    }

    private boolean checkPrice(ItemOrderVo itemOrderVo) {
        boolean flag = false;
        if(itemOrderVo != null
                && itemOrderVo.getItemOrderInfoVos() != null
//                && itemOrderVo.getReceivingAddress() != null   //收货地址可以为空
//                && itemOrderVo.getReceivingAddress().getReceivingNo() != null
                && itemOrderVo.getBuyer() != null
                && itemOrderVo.getBuyer().getBusinessNo() != null){
            flag = true;
        }
        List<ItemOrderInfoVo> orderVos = itemOrderVo.getItemOrderInfoVos();
        for(ItemOrderInfoVo orderVo : orderVos){
            if(orderVo == null
                    || orderVo.getItem() == null
                    || orderVo.getItem().getItemNo() == null){
               flag = false;
            }
        }
        return flag;
    }
}
