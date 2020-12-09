package com.yangwang.application.pet.market.controller.market.promotion;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.model.params.QueryCouponListParam;
import com.yangwang.application.pet.market.service.facade.common.CouponListService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponTypeService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 优惠券列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className CouponListController
 * @date 2020/3/27 17:20
 **/
@RestController
@RequestMapping("/api/business/coupon/list")
@Api(description = "优惠券列表")
public class CouponListController {
    @Resource
    CouponListService couponListService;

    @Resource
    CouponTypeService couponTypeService;

    @GetMapping()
    @ApiOperation(value = "获取优惠券列表")
    public JsonResult listByParam(@RequestParam("queryParam") String queryParam) {
        QueryCouponListParam queryCouponListParam = QueryCouponListParam.toObject(queryParam);
        if (queryCouponListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(couponListService.listByParam(queryCouponListParam));
    }

    @GetMapping("/type")
    @ApiOperation(value = "获取该用户可兑换优惠券列表")
    public JsonResult listExchangeable(@RequestParam(value = "preferentialType", required = false) Integer preferentialType){
        //1:折扣券,2:代金券,3:领用券.不传参数查询所有
        return JsonResult.success(couponTypeService.list(preferentialType));
    }

    @ApiOperation("获取新客大礼包优惠券类型")
    @GetMapping("/listNewGuestGiftBag")
    public JsonResult listNewGuestGiftBag(){
        List<CouponType> couponTypes = couponTypeService.listNewGuestGiftBag();
        return JsonResult.success(couponTypes);
    }
}
