package com.yangwang.application.pet.market.controller.market.promotion;

import com.yangwang.application.pet.market.model.params.QueryUsableCouponListParam;
import com.yangwang.application.pet.market.service.facade.common.CouponListService;
import com.yangwang.sysframework.utils.JsonResult;
import com.yangwang.sysframework.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-28 11:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/coupon/usable/list")
@Api(description = "本单据可用优惠券")
public class CouponUsableController {

    @Autowired
    CouponListService couponListService;

    @GetMapping("")
    @ApiOperation(value = "获取本单可使用的券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "businessNo", value = "用户编号", required = true),
            @ApiImplicitParam(name = "shopNo", value = "商家编号", required = true),
            @ApiImplicitParam(name = "type", value = "类别(1.宠物;2.商品;3.服务)", required = true),
            @ApiImplicitParam(name = "key", value = "查询的关键字", required = true),
            @ApiImplicitParam(name = "subtotalAmount", value = "本单金额", type = "number", required = true)
    })
    public JsonResult listUsableCoupon(BigDecimal subtotalAmount, String businessNo, String shopNo, int type, String key) throws Exception {
        QueryUsableCouponListParam queryUsableCouponListParam = new QueryUsableCouponListParam();

        queryUsableCouponListParam.setSubtotalAmount(subtotalAmount);
        queryUsableCouponListParam.setBusinessNo(businessNo);
        queryUsableCouponListParam.setShopNo(shopNo);
        queryUsableCouponListParam.setType(type);
        queryUsableCouponListParam.setKey(key);

        return JsonResult.success(couponListService.listUsableCoupon(queryUsableCouponListParam));
    }
}
