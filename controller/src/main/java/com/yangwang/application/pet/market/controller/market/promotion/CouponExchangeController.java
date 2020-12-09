package com.yangwang.application.pet.market.controller.market.promotion;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.enums.VerifyCodeEnum;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.model.params.CouponExchangeParam;
import com.yangwang.application.pet.market.service.facade.coupon.CouponExchangeService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponTypeService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.spring.coupon.CouponExchangeServiceImpl;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yang hituzi
 * @description 优惠券兑换
 * @date 2020年4月8日 11:59:30
 */
@RestController
@RequestMapping("/api/business/coupon/exchange")
@Api(description = "优惠券")
public class CouponExchangeController {
    @Resource
    CouponExchangeService couponExchangeService;

    @Resource
    BusinessService businessService;

    @Resource
    CouponTypeService couponTypeService;

    /**
     * 兑换优惠券
     *
     * @param couponExchangeParam
     * @param bindingResult
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author yang hituzi
     * @date 15:19 2020/4/8
     */
    @PostMapping()
    @ApiOperation(value = "积分兑换优惠券")
    public JsonResult couponExchange(@Validated @RequestBody CouponExchangeParam couponExchangeParam,
                                     BindingResult bindingResult) {
        //验证传入参数是否为空,并且长度大于0
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(RespondCodeEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        int count = couponExchangeService.exchangeCoupon(couponExchangeParam);

        //积分不够兑换优惠券
        if (count == CouponExchangeServiceImpl.LESS_CREDIT) {
            return JsonResult.fail(RespondCodeEnum.INSERT_ERROR.getCode(), "积分不足!");
        }

        //兑换次数超过上限
        if (count == CouponExchangeServiceImpl.BEYOND_QUOT) {
            return JsonResult.fail(RespondCodeEnum.INSERT_ERROR.getCode(), "兑换次数超过上限!");
        }

        //兑换失败
        if (count == 0) {
            return JsonResult.fail(RespondCodeEnum.UNKNOWN_ERROR.getCode(), "连接超时,请重试!");
        }

        return JsonResult.success(RespondCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 使用核销码核销优惠券
     *
     * @param verifyCode
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author yang hituzi
     * @date 15:30 2020/4/8
     */
    @PutMapping()
    @ApiOperation(value = "核销优惠券")
    public JsonResult verifyCoupon(@RequestParam("verifyCode") String verifyCode) {
        //核销码为空
        if (StringUtils.isBlank(verifyCode)) {
            return JsonResult.fail(RespondCodeEnum.PARAM_ERROR.getCode(), "请输入核销码!");
        }

        int count = couponExchangeService.verifyCoupon(verifyCode);
        //无效的核销码
        if (VerifyCodeEnum.INVALID_CODE.getErrorCode() == count) {
            return JsonResult.fail(RespondCodeEnum.UPDATE_ERROR.getCode(), VerifyCodeEnum.INVALID_CODE.getErrorMsg());
        }
        //优惠券已失效
        if (VerifyCodeEnum.DISABLED_COUPON.getErrorCode() == count) {
            return JsonResult.fail(RespondCodeEnum.UPDATE_ERROR.getCode(), VerifyCodeEnum.DISABLED_COUPON.getErrorMsg());
        }
        //优惠券已使用
        if (VerifyCodeEnum.USED_COUPON.getErrorCode() == count) {
            return JsonResult.fail(RespondCodeEnum.UPDATE_ERROR.getCode(), VerifyCodeEnum.USED_COUPON.getErrorMsg());
        }

        return JsonResult.success(RespondCodeEnum.SUCCESS.getMessage());
    }

    @ApiOperation("领取新客大礼包")
    @PostMapping("/receiveNewGuestGiftBag")
    public JsonResult receiveNewGuestGiftBag(@RequestParam("businessNo") String businessNo){
        //获取所有新客礼包优惠券类型
        List<CouponType> couponTypes = couponTypeService.listNewGuestGiftBag();
        if(CollectionUtils.isNotEmpty(couponTypes)){
            for (CouponType couponType:couponTypes){
                //领取新客礼包优惠券
                couponExchangeService.receiveCoupon(new CouponExchangeParam(couponType.getCouponTypeID(), businessNo));
            }
            //修改用户领取状态
            businessService.updateNewGiftBag(businessNo);
        }
        return JsonResult.success();
    }
}
