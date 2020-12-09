package com.yangwang.application.pet.market.service.spring.coupon;

import com.yangwang.application.pet.market.common.enums.CreditFlowTypeEnum;
import com.yangwang.application.pet.market.common.enums.VerifyCodeEnum;
import com.yangwang.application.pet.market.dao.market.coupon.CouponExchangeMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.common.coupon.CouponType;
import com.yangwang.application.pet.market.model.market.CreditFlow;
import com.yangwang.application.pet.market.model.params.CouponExchangeParam;
import com.yangwang.application.pet.market.service.facade.coupon.CouponExchangeService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponTypeService;
import com.yangwang.application.pet.market.service.facade.market.CreditFlowService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author yang hituzi
 * @description 兑换优惠券
 * @date 2020年4月8日 10:25:44
 */
@Service
public class CouponExchangeServiceImpl implements CouponExchangeService {

    @Resource
    CouponTypeService couponTypeService;

    @Resource
    BusinessService businessService;

    @Resource
    CouponExchangeMapper couponExchangeMapper;

    @Resource
    CouponService couponService;

    @Resource
    CreditFlowService creditFlowService;

    /**积分不足*/
    public static int LESS_CREDIT = -1;

    /**兑换数量超过上限*/
    public static int BEYOND_QUOT = -2;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int exchangeCoupon(CouponExchangeParam couponExchangeParam) {

        long couponTypeID = couponExchangeParam.getCouponTypeID();
        String businessNo = couponExchangeParam.getBusinessNo();

        //获取优惠券类型
        CouponType couponType = couponTypeService.get(couponTypeID);

        //获取用户信息
        Business business = businessService.getByBusinessNoWithOutState(businessNo);

        //验证用户积分是否足够兑换优惠券
        if(verifyCredit(couponType,business)){
            //用户积分不足
            return LESS_CREDIT;
        }

        //验证兑换数量是否超过优惠券规定数量上限
        if(verifyQuot(couponType,business)){
            //兑换数量大于等于上限
            return BEYOND_QUOT;
        }

        //生成优惠券
        String verifyCode = createVerifyCode();
        Coupon coupon = new Coupon(couponType,business,false,false,verifyCode);
        int count = couponService.save(coupon);

        //扣除用户积分
        businessService.updateCreditSub(businessNo,couponType.getCouponCredit());

        //回写积分流水
        CreditFlow creditFlow = new CreditFlow(business, DateUtil.format(new Date(),DateUtil.FORMAT_FULL),0 - couponType.getCouponCredit(),
                businessService.getByBusinessNoWithOutState(businessNo).getCredit(),String.valueOf(couponService.getByVerifyCode(verifyCode).getCouponID()),
                null, CreditFlowTypeEnum.COUPON_EXCHANGE.getCreditFlowType());
        creditFlowService.save(creditFlow);

        return count;
    }

    @Override
    public int verifyCoupon(String verifyCode) {
        Coupon coupon = couponService.getByVerifyCode(verifyCode);

        //无效的核销码
        if(coupon == null){
            return VerifyCodeEnum.INVALID_CODE.getErrorCode();
        }

        //优惠券已失效
        if(coupon.isInvalid()){
            return VerifyCodeEnum.DISABLED_COUPON.getErrorCode();
        }

        //优惠券已使用
        if(coupon.isUsed()){
            return VerifyCodeEnum.USED_COUPON.getErrorCode();
        }

        //使用核销码核销优惠券
        return couponExchangeMapper.updateCouponByVerifyCode(verifyCode);
    }

    @Override
    public int receiveCoupon(CouponExchangeParam couponExchangeParam) {
        long couponTypeID = couponExchangeParam.getCouponTypeID();
        String businessNo = couponExchangeParam.getBusinessNo();

        //获取优惠券类型
        CouponType couponType = couponTypeService.get(couponTypeID);

        //获取用户信息
        Business business = businessService.getByBusinessNoWithOutState(businessNo);


        //验证兑换数量是否超过优惠券规定数量上限
        if(verifyQuot(couponType,business)){
            //兑换数量大于等于上限
            return BEYOND_QUOT;
        }

        //生成优惠券
        String verifyCode = createVerifyCode();
        Coupon coupon = new Coupon(couponType,business,false,false,verifyCode);
        int count = couponService.save(coupon);
        return count;
    }

    /**
     *
     * 自动生成核销码
     * @param
     * @return java.lang.String
     * @author yang hituzi
     * @date 10:31 2020/4/8
     */
    private synchronized String createVerifyCode(){
        return Long.toString(System.currentTimeMillis(),36);
    }

    /**
     *
     * 验证用户积分是否够兑换优惠券
     * @param couponType
     * @param business
     * @return java.lang.Boolean
     * @author yang hituzi
     * @date 10:48 2020/4/8
     */
    private Boolean verifyCredit(CouponType couponType, Business business){
        //积分不够返回true,足够兑换优惠券返回false
        return business.getCredit() < couponType.getCouponCredit();
    }

    /**
     *
     * 验证用户兑换该优惠券数量是否超过 优惠券规定每个用户兑换上限
     * @param couponType
     * @param business
     * @return java.lang.Boolean
     * @author yang hituzi
     * @date 10:52 2020/4/8
     */
    private Boolean verifyQuot(CouponType couponType, Business business){
        if(couponType.getQuota() == 0){
            //优惠券领用数量无限制
            return false;
        }

        //获取优惠券限定兑换数量上限
        int alreadyExchangeNum = couponExchangeMapper.countCouponByBusinessNo(couponType.getCouponTypeID(),business.getBusinessNo());

        //超过领用数量返回true,否则返回false
        return alreadyExchangeNum >= couponType.getQuota();
    }

}
