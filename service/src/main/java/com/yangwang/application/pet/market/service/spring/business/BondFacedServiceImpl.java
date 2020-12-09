package com.yangwang.application.pet.market.service.spring.business;

import com.yangwang.application.pet.market.common.enums.BondStateEnum;
import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.common.enums.WeChatPayCallBackEnum;
import com.yangwang.application.pet.market.model.business.Bond;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.BaseUnifiedPay;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.service.facade.business.BondFacedService;
import com.yangwang.application.pet.market.service.facade.common.AccountService;
import com.yangwang.application.pet.market.service.service.BondService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 商家保证金
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className BondFacedServiceImpl
 * @date 2020/3/24 16:29
 **/
@Service
public class BondFacedServiceImpl implements BondFacedService {
    @Resource
    BondService bondService;

    @Resource
    BusinessService businessService;

    @Resource
    AccountService accountService;

    @Value("${localHost}")
    String localHost;

    @Override
    public int save(Bond bond) {
        if (bondService.getByBusinessNo(bond.getBusiness().getBusinessNo()) == null) {
            bond.setBillNo(String.valueOf(System.currentTimeMillis()));
            bond.setCreateDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
            bond.setCreateTime(DateUtil.format(new Date(), DateUtil.FORMAT_TIME));
            bond.setPaymentAmount(BigDecimal.valueOf(0.01));
            bond.setPaymentState(OrderStateEnum.PAY_UNPAID.getState());
            return bondService.save(bond);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int payBond(String bondNo) {
        // 获取订单
        Bond bond = bondService.get(bondNo);
        if (bond != null && BondStateEnum.UNPAID.getState() == bond.getPaymentState()) {
            // 修改商家是否缴纳保证金状态
            businessService.updatePayBond(bondNo, BondStateEnum.PAID.getState());
            // 更新保证金订单状态
            bondService.updateState(bondNo, OrderStateEnum.PAY_PAID.getState());

            return 1;
        }

        return 0;
    }

    @Override
    public Map<String, String> getBondPayParam(String businessNo, String ipAddress) throws Exception {
        Bond bond = bondService.getByBusinessNo(businessNo);
        if (bond != null && OrderStateEnum.PAY_UNPAID.getState() == bond.getPaymentState()) {
           return accountService.unifiedPay(new BaseUnifiedPay() {
                @Override
                public String getOutTradeNo() {
                    return bond.getBillNo();
                }

                @Override
                public Business getSeller() {
                    return null;
                }

                @Override
                public Business getBuyer() {
                    return bond.getBusiness();
                }

                @Override
                public Business getDistributor() {
                    return null;
                }

                @Override
                public String getNotifyUrl() {
                    return WeChatPayCallBackEnum.BOND_ORDER.getCompleteCallBackUrl(localHost, bond.getBillNo());
                }

                @Override
                public String getBody() {
                    return WeChatPayCallBackEnum.BOND_ORDER.getParamBody();
                }

                @Override
                public BigDecimal getTotalFee() {
                    return bond.getPaymentAmount();
                }

                @Override
                public BigDecimal getUsedBalance() {
                    return BigDecimal.ZERO;
                }

                @Override
                public int getPoint() {
                    return 0;
                }

                @Override
                public Coupon getUsedCoupon() {
                    return null;
                }

                @Override
                public BigDecimal getUsedCouponAmount() {
                    return null;
                }

                @Override
                public BigDecimal getBrokerage() {
                    return BigDecimal.ZERO;
                }

                @Override
                public String getIpAddress() {
                    return ipAddress;
                }

                @Override
                public String getOrderNo() {
                    return "";
                }

               @Override
               public BigDecimal getShopAmount() {
                   return null;
               }
           });
        }

        return null;
    }

    @Override
    public Bond getByBusinessNo(String businessNo) {
        return bondService.getByBusinessNo(businessNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int payCallBack(String bondNo) {
        // 获取保证金状态
        Bond bond = bondService.get(bondNo);
        if (bond != null && OrderStateEnum.PAY_UNPAID.getState() == bond.getPaymentState()) {
            // 修改订单状态
            bondService.updateState(bondNo, OrderStateEnum.PAY_PAID.getState());

            // 修改用户保证金状态
            businessService.updatePayBond(bond.getBusiness().getBusinessNo(), BondStateEnum.PAID.getState());
        }
        return 1;
    }
}
