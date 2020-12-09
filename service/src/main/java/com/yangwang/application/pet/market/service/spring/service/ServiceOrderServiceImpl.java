package com.yangwang.application.pet.market.service.spring.service;

import com.yangwang.application.pet.market.common.enums.BillTypeEnum;
import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.common.enums.WeChatPayCallBackEnum;
import com.yangwang.application.pet.market.dao.service.ServiceOrderMapper;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.BaseUnifiedPay;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.market.ServiceOrder;
import com.yangwang.application.pet.market.service.facade.common.AccountService;
import com.yangwang.application.pet.market.service.facade.common.MessagePushService;
import com.yangwang.application.pet.market.service.facade.common.SMSMessageReminderService;
import com.yangwang.application.pet.market.service.facade.service.ServiceOrderService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.StringUtil;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 服务订单
 * </p>
 *
 * @author HuJi
 * @date 9:04 2020/3/31
 **/
@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    AccountService accountService;

    @Resource
    ServiceOrderMapper serviceOrderMapper;

    @Resource
    BusinessService businessService;

    @Resource
    SMSMessageReminderService smsMessageReminderService;

    @Resource(name = "MessagePushService")
    MessagePushService messagePushService;

    @Value("${localHost}")
    String localHost;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insertOrder(ServiceOrder order, String ipAddress) {
        order.setOrderNo(TypeConvertUtil.$Str(StringUtil.$Str(BillTypeEnum.SERVICE_ORDER.getBillType()) + DateUtil.format(new Date(), "yyyyMMddHHmmss")));

        Date now = new Date();
        order.setCreateDate(DateUtil.format(now));
        order.setCreateTime(DateUtil.format(now, "HH:mm:ss"));
        order.setPaymentState(0);
        order.setVerifyState(0);
        order.setEvaluateState(0);
        order.setRefundsState(0);
        order.setShopAmount(order.getPaymentAmount());

        serviceOrderMapper.insertOrder(order);

        return order.getOrderNo();
    }

    @Override
    public List<ServiceOrder> listOrdersByShop(String businessNo, int offset, int limit) throws Exception {
        return serviceOrderMapper.listOrdersByShop(businessNo, offset, limit);
    }

    @Override
    public List<ServiceOrder> listOrderByBusiness(String businessNo, int offset, int limit) throws Exception {
        return serviceOrderMapper.listOrderByBusiness(businessNo, offset, limit);
    }

    @Override
    public int updateVerifyState(String orderNo) {
        return serviceOrderMapper.updateVerifyState(orderNo);
    }

    @Override
    public Map<String, String> getPayParam(String orderNo, String ipAddress) throws Exception {
        ServiceOrder serviceOrder = serviceOrderMapper.getServiceOrder(orderNo);
        if (serviceOrder != null) {
            Business buyer = businessService.getByBusinessNoWithOutState(serviceOrder.getBuyer().getBusinessNo());
            return accountService.unifiedPay(new BaseUnifiedPay() {
                @Override
                public String getOutTradeNo() {
                    return String.valueOf(serviceOrder.getOrderNo());
                }

                @Override
                public Business getSeller() {
                    return serviceOrder.getShop();
                }

                @Override
                public Business getBuyer() {
                    return buyer;
                }

                @Override
                public Business getDistributor() {
                    return serviceOrder.getDistributor();
                }

                @Override
                public String getNotifyUrl() {
                    return WeChatPayCallBackEnum.SERVICE_ORDER.getCompleteCallBackUrl(localHost, String.valueOf(orderNo));
                }

                @Override
                public String getBody() {
                    return WeChatPayCallBackEnum.SERVICE_ORDER.getParamBody();
                }

                @Override
                public BigDecimal getTotalFee() {
                    return serviceOrder.getPaymentAmount();
                }

                @Override
                public BigDecimal getUsedBalance() {
                    return BigDecimal.ZERO;
                }

                @Override
                public int getPoint() {
                    return serviceOrder.getPaymentAmount().intValue();
                }

                @Override
                public Coupon getUsedCoupon() {
                    return serviceOrder.getCoupon();
                }

                @Override
                public BigDecimal getUsedCouponAmount() {
                    return serviceOrder.getCouponAmount();
                }

                @Override
                public BigDecimal getBrokerage() {
                    return serviceOrder.getDistributorAmount();
                }

                @Override
                public String getIpAddress() {
                    return ipAddress;
                }

                @Override
                public String getOrderNo() {
                    return serviceOrder.getOrderNo();
                }

                @Override
                public BigDecimal getShopAmount() {
                    return serviceOrder.getShopAmount();
                }
            });
        }
        return null;
    }

    @Override
    public void payCallBack(String orderNo) {
        serviceOrderMapper.updatePayState(orderNo, OrderStateEnum.PAY_PAID.getState());
        ServiceOrder serviceOrder = serviceOrderMapper.getServiceOrder(orderNo);
        //发送站内信提示商家
        messagePushService.messagePushBusiness(serviceOrder.getShop().getBusinessNo(), MessageTypeEnum.COMMODITY_SALESTIPS.getType(),orderNo );
        //获取商家
        Business business = businessService.getByBusinessNoWithOutState(serviceOrder.getShop().getBusinessNo());
        //发送短信提示商家
        try {
            smsMessageReminderService.sendMsgToBusiness(business.getContactPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServiceOrder getServiceOrder(String billNo) {
        return serviceOrderMapper.getServiceOrder(billNo);
    }

    @Override
    public int updateServicePayment(ServiceOrder serviceOrder) {
        return serviceOrderMapper.updateServicePayment(serviceOrder);
    }
}
