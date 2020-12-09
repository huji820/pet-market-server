package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.*;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.BaseUnifiedPay;
import com.yangwang.application.pet.market.model.common.Pet;
import com.yangwang.application.pet.market.model.common.PetGroupon;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.model.vo.OrderPriceVo;
import com.yangwang.application.pet.market.model.vo.PetVo;
import com.yangwang.application.pet.market.service.facade.common.*;
import com.yangwang.application.pet.market.service.facade.coupon.CouponFacedService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponService;
import com.yangwang.application.pet.market.service.facade.customer.PetOrderService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.spring.chain.order.pet.BuyerChainServiceImpl;
import com.yangwang.application.pet.market.service.spring.chain.order.pet.DistributorChainServiceImpl;
import com.yangwang.application.pet.market.service.spring.chain.order.pet.PetChainServiceImpl;
import com.yangwang.application.pet.market.service.spring.chain.order.pet.ReceivingChainServiceImpl;
import com.yangwang.application.pet.market.service.spring.factory.CouponFactoryProducer;
import com.yangwang.sysframework.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderFacedServiceImpl
 * @date 2020/3/28 9:58
 **/
@Service
public class PetOrderFacedServiceImpl implements PetOrderFacedService {

    @Resource
    PetOrderService petOrderService;

    @Resource
    PetTransportService petTransportService;

    @Resource
    BuyerChainServiceImpl buyerChainServiceImpl;

    @Resource
    DistributorChainServiceImpl distributorChainServiceImpl;

    @Resource
    PetChainServiceImpl petChainServiceImpl;

    @Resource
    ReceivingChainServiceImpl receivingChainServiceImpl;

    @Resource
    PetDetailService petDetailService;

    @Resource
    CouponFactoryProducer<PetOrder> couponFactoryProducer;

    @Resource
    CouponService couponService;

    @Resource
    PetService petService;

    @Resource
    ReceivingAddressService receivingAddressService;

    @Resource
    AccountService accountService;

    @Resource
    CouponFacedService couponFacedService;

    @Resource
    BusinessService businessService;

    @Resource
    SMSMessageReminderService smsMessageReminderService;

    @Resource
    PetIssuedBehalfService petIssuedBehalfService;

    @Resource(name = "MessagePetService")
    MessagePushService messagePushService;

    @Value("${localHost}")
    String localHost;

    @ApiModelProperty("宠物订单Vo")
    PetOrderVo petOrderVo;

    /**
     * <p>
     * 获取最新支付价格
     * </p>
     *
     * @param paymentAmount
     * @return java.math.BigDecimal
     * @author GuoPengCheng
     * @date 14:47 2020/3/30
     */
    @Override
    public BigDecimal getPaymentAmounts(BigDecimal paymentAmount,String consignOrderNo) {
        //通过运单号获取订单
        PetOrder petOrder = petOrderService.getPetOrderByWaybill(consignOrderNo);
        if(petOrder == null){
            return null;
        }
        //不包邮
        if(petOrder.getFreeShipping()==0){
            //运费
            BigDecimal carriage = paymentAmount;
            //订单号
            String orderNo = petOrder.getOrderNo();
            //最终价格(运费+售价-商品优惠卷抵用金额)
            BigDecimal payAmount = petOrder.getRetailPrice().add(carriage).subtract(petOrder.getCouponAmount());
            int i = petOrderService.updateOrderCarriage(carriage, payAmount, orderNo);
        }
//        this.FreightRate = paymentAmount;
//        //如果有修改运价，且新运价的价格不为null，则重新调用一次获取价格再次计算
//        if(this.FreightRate!=null){
//            getPrice(this.petOrderVo);
//            this.petOrderVo = null;
//            this.OrderNo = null;
//        }
//        return this.FreightRate;
        return paymentAmount;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int uploadPaymentVoucher(String orderNo, String paymentVoucher) {
        PetOrder order = petOrderService.get(orderNo);
        //订单待付款状态下才可上传收款凭证
        if(OrderStateEnum.PAY_UNPAID.getState() == order.getPaymentState()){
            // 添加支付凭证
            int i = petOrderService.uploadPaymentVoucher(orderNo, paymentVoucher);
            if (i > 0) {
                try {
                    //回调支付成功
                    payCallBack(orderNo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateOrderPrice(String orderNo, BigDecimal price) {
        // 获取订单
        PetOrder petOrder = petOrderService.get(orderNo);
        // 如果订单金额没有改变则不修改订单支付
        if (petOrder != null && petOrder.getPaymentAmount().compareTo(price) != 0) {
            // 重新生成outTradeNo
            petOrder.setOutTradeNo(DateUtil.format(new Date(), "yyyyMMddHHmmss") + (int)(Math.random()*1000));
            petOrder.setPaymentAmount(price);
            // petOrderService.getOrderPaymentAmount(petOrder);
            return petOrderService.updateOrderPrice(petOrder);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long save(PetOrderVo petOrderVo) {

        if(petOrderVo.getPet().getSourcePetNo() != null){   //宠物不是源头宠物
            if(petOrderVo.getShareBusiness()==null){    //没有分享分销人
                //把当前商家设置为分销商
                petOrderVo.setShareBusiness(petOrderVo.getPet().getBusiness());
            }
            //获取源头宠物，替代当前购买的宠物
            Pet pet = petService.get(petOrderVo.getPet().getSourcePetNo());
            petOrderVo.setPet(pet);
        }

        this.petOrderVo = petOrderVo;

        // 生成一个单号
        long orderNo = System.currentTimeMillis();

        // 获取和订单价格
        OrderPriceVo orderPriceVo = getPrice(petOrderVo);

        // 校验订单
        orderPriceVo.checkSame(petOrderVo);

        // 校验订单
        petOrderVo.setCheckState(true);
        // 宠物以及购买人校验
        petChainServiceImpl.setNext(buyerChainServiceImpl);
        // 分销校验
        buyerChainServiceImpl.setNext(distributorChainServiceImpl);
        // 收货地址校验
        distributorChainServiceImpl.setNext(receivingChainServiceImpl);
        petChainServiceImpl.check(petOrderVo);
        // 判断校验是否通过
        if (!petOrderVo.isCheckState()) {
            return 0;
        }

        String transportNo = null;
        if (petOrderVo.getPet().getFreeShipping() != null
                && petOrderVo.getPet().getFreeShipping() == 0
                && petOrderVo.getTransportType() != null
                && petOrderVo.getTransportType() != 0) {
            // 新增运输订单
            transportNo = petTransportService.saveTransportOrder(petOrderVo);
            if (transportNo == null) {
                throw new RuntimeException("新增运输订单失败！");
            }
        }

        // 保存订单
        PetOrder petOrder = petOrderVo.convertToPetOrder(transportNo);

        if(petOrderVo.getShareBusiness()!=null){
            // 分销金额 = （支付金额 - 运费） * 佣金比例 / 100
            petOrder.setDistributorAmount((orderPriceVo.getPaymentAmount().subtract(orderPriceVo.getTransportAmount()))
                    .multiply(petOrderVo.getPet().getCommission()).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP, 2));
        }else{  //没有分销人分销金额为0
            petOrder.setDistributorAmount(BigDecimal.ZERO);
        }

        // 原价 = (宠物原价 * 宠物数量)
        petOrder.setOriginalAmount(petOrderVo.getPet().getRetailPrice().multiply(BigDecimal.valueOf(petOrderVo.getQty())));

        // 商家应收金额 = (支付支付金额 - 运费 - 分销金额)
        petOrder.setShopAmount(petOrder.getPaymentAmount().subtract(petOrder.getCarriage()).subtract(petOrder.getDistributorAmount()));

        petOrder.setOrderNo(String.valueOf(orderNo));
        petOrder.setOutTradeNo(String.valueOf(petOrder.getOrderNo()));

        //获取分销员
        Business ShareBusiness = null;
        if(petOrderVo.getShareBusiness() != null){
            ShareBusiness = businessService.getByBusinessNoWithOutState(petOrderVo.getShareBusiness().getBusinessNo());
            petOrderVo.setShareBusiness(ShareBusiness);
        }

        // 设置分销员
        petOrder.setDistributor(ShareBusiness);
        petOrderService.save(petOrder);

        // 修改优惠券状态
        if (petOrderVo.getCoupon() != null) {
            couponService.updateUsedState(petOrderVo.getCoupon().getCouponID(), true);
        }

        // 支付订单 TODO 上线时需要删除
        /*try {
            this.payCallBack(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return orderNo;
    }

    @Override
    public int cancel(long orderNo) {
        return 0;
    }

    @Override
    public OrderPriceVo getPrice(PetOrderVo petOrderVo) {
        OrderPriceVo result = new OrderPriceVo();

        // 设置完整的对象
        addFullObj(petOrderVo);

        // 获取宠物数量
        result.setQty(petOrderVo.getQty());

        // 获取宠物价格
        PetVo petVo = petDetailService.get(petOrderVo.getPet().getPetNo());
        BigDecimal petPrice = getPetPrice(petVo, petOrderVo.getQty());
        petOrderVo.setGoodsPrice(petPrice);
        result.setGoodsPrice(petPrice);

        if (petPrice == null) {
            result.setPriceState(OrderPriceVo.ERROR_PRICE);
            return result;
        }

        // 计算宠物金额
        BigDecimal petAmount = petPrice.multiply(BigDecimal.valueOf(petOrderVo.getQty()));
        petOrderVo.setGoodsAmount(petAmount);
        result.setGoodsAmount(petAmount);

        // 计算优惠券抵用金额
        BigDecimal couponDisCountAmount = null;
        if (petOrderVo.getCoupon() != null) {
            Coupon coupon = couponFacedService.getUseful(petOrderVo.getCoupon().getCouponID());
            if (coupon != null) {
                couponDisCountAmount = couponFactoryProducer.getFactory(petOrderVo.convertToPetOrder(null))
                        .getCouponPetService(coupon.getCouponType())
                        .calcDisCount(petOrderVo);
            }
        } else {
            couponDisCountAmount = BigDecimal.ZERO;
        }

        if (couponDisCountAmount == null) {
            result.setPriceState(OrderPriceVo.ERROR_COUPON);
            return result;
        }

        result.setCouponDiscountAmount(couponDisCountAmount);

        BigDecimal transportPrice = BigDecimal.ZERO;
        if (petVo.getPet().getFreeShipping() != null
                && petVo.getPet().getFreeShipping() == 0
                && petOrderVo.getTransportType() != null
                && petOrderVo.getTransportType() > 0) {
            // 计算运输价格
            transportPrice = petTransportService.getTransportPrice(petOrderVo);
        }

        result.setTransportAmount(transportPrice);

        // 计算最终价格
        result.setPaymentAmount(result.calcPaymentAmount());

        result.setPriceState(OrderPriceVo.SUCCESS_CALC);

        return result;
    }

    @Override
    public BigDecimal getPetPrice(String petNo, int qty) {
        PetVo petVo = petDetailService.get(petNo);
        if (petVo != null) {
            return getPetPrice(petVo, qty);
        }
        return null;
    }

    @Override
    public Map<String, String> getPayParam(String orderNo, String ipAddress) throws Exception {
        // 获取订单
        PetOrder petOrder = petOrderService.get(orderNo);
        // 重新生成outTradeNo
        petOrder.setOutTradeNo(DateUtil.format(new Date(), "yyyyMMddHHmmss")+(int)(Math.random()*1000));

        if (petOrder != null && OrderStateEnum.PAY_UNPAID.getState() == petOrder.getPaymentState()) {
            return accountService.unifiedPay(new BaseUnifiedPay() {
                @Override
                public String getOutTradeNo() {
                    return petOrder.getOutTradeNo();
                }

                @Override
                public Business getSeller() {
                    return petOrder.getShop();
                }

                @Override
                public Business getBuyer() {
                    return petOrder.getBuyer();
                }

                @Override
                public Business getDistributor() {
                    return petOrder.getDistributor();
                }

                @Override
                public String getNotifyUrl() {
                    return WeChatPayCallBackEnum.PET_ORDER.getCompleteCallBackUrl(localHost, String.valueOf(petOrder.getOrderNo()));
                }

                @Override
                public String getBody() {
                    return WeChatPayCallBackEnum.PET_ORDER.getParamBody();
                }

                @Override
                public BigDecimal getTotalFee() {
                    return petOrder.getPaymentAmount();
                }

                @Override
                public BigDecimal getUsedBalance() {
                    return BigDecimal.ZERO;
                }

                @Override
                public int getPoint() {
                    return petOrder.getPaymentAmount().intValue();
                }

                @Override
                public Coupon getUsedCoupon() {
                    return petOrder.getCoupon();
                }

                @Override
                public BigDecimal getUsedCouponAmount() {
                    return petOrder.getCouponAmount();
                }

                @Override
                public BigDecimal getBrokerage() {
                    return petOrder.getDistributorAmount();
                }

                @Override
                public String getIpAddress() {
                    return ipAddress;
                }

                @Override
                public String getOrderNo() {
                    return petOrder.getOrderNo();
                }

                @Override
                public BigDecimal getShopAmount() {
                    return petOrder.getPaymentAmount();
                }
            });
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int payCallBack(String orderNo) throws Exception {
        // 获取订单
        PetOrder petOrder = petOrderService.get(orderNo);
        // 订单状态校验
        if (petOrder != null && OrderStateEnum.PAY_UNPAID.getState() == petOrder.getPaymentState()) {
            // 买家
            Business buyer = businessService.getByBusinessNoWithOutState(petOrder.getBuyer().getBusinessNo());

            // 卖家
            Business shop = businessService.getByBusinessNoWithOutState(petOrder.getShop().getBusinessNo());

            // 分销
            Business distributor = petOrder.getDistributor() == null ? null : businessService.getByBusinessNoWithOutState(petOrder.getDistributor().getBusinessNo());

            // 修改订单为已支付状态
            petOrderService.updatePaymentState(orderNo, OrderStateEnum.PAY_PAID.getState());
            // 积分等
            accountService.petOrder(new BaseUnifiedPay() {
                @Override
                public String getOutTradeNo() {
                    return petOrder.getOutTradeNo();
                }

                @Override
                public Business getSeller() {
                    return shop;
                }

                @Override
                public Business getBuyer() {
                    return buyer;
                }

                @Override
                public Business getDistributor() {
                    return distributor;
                }

                @Override
                public String getNotifyUrl() {
                    return null;
                }

                @Override
                public String getBody() {
                    return null;
                }

                @Override
                public BigDecimal getTotalFee() {
                    return petOrder.getPaymentAmount();
                }

                @Override
                public BigDecimal getUsedBalance() {
                    return BigDecimal.ZERO;
                }

                @Override
                public int getPoint() {
                    return petOrder.getPaymentAmount().intValue();
                }

                @Override
                public Coupon getUsedCoupon() {
                    return petOrder.getCoupon();
                }

                @Override
                public BigDecimal getUsedCouponAmount() {
                    return petOrder.getCouponAmount();
                }

                @Override
                public BigDecimal getBrokerage() {
                    return petOrder.getDistributorAmount();
                }

                @Override
                public String getIpAddress() {
                    return null;
                }

                @Override
                public String getOrderNo() {
                    return petOrder.getOrderNo();
                }

                @Override
                public BigDecimal getShopAmount() {
                    return petOrder.getShopAmount();
                }
            });

            // 回写运输订单
            petTransportService.payOrder(petOrder.getWayBill());

            // 宠物销量回写
            petService.updateSalesVolumeAdd(petOrder.getPetNo(), petOrder.getQty());

            //修改宠物状态为已售出
            petService.updatePetIsSell(petOrder.getPetNo(), 1);

            //修改代发宠物状态为已售出
            petIssuedBehalfService.updatePetIsSell(petOrder.getPetNo(), 1);

            //给商家发送站内信提示
            messagePushService.messagePushBusiness(petOrder.getPetNo(), MessageTypeEnum.COMMODITY_SALESTIPS.getType(),orderNo);

            //给商家发送宠物售出短信提示
            smsMessageReminderService.sendMsgToBusiness(shop.getContactPhone());

            //给关注了该宠物的用户发送站内信消息
            messagePushService.messagePush(petOrder.getPetNo(), MessageTypeEnum.COMMODITY_SOLD.getType());

            // 如果用户是个人商家 则将商品下架
            if (AuthTypeEnum.INDIVIDUAL.getType() == shop.getAuthType()) {
                petService.updatePetState(petOrder.getPetNo(), OnSaleStateEnum.OFF_SALE.getType());
            }
        }

        return 1;
    }

    @Override
    public int cancelUnpaidOrder() {
        // 获取昨天的时间
        String yesterday = DateUtil.formatFull(DateUtil.getAddHourDate(new Date(), -24 * 2));

        // 修改未支付的订单
        petOrderService.cancelUnpaidOrder(yesterday);

        return 0;
    }

    @Override
    public int signFor(String orderNo) {
        // 获取订单
        PetOrder petOrder = petOrderService.get(orderNo);
        // 订单不为空 已经支付，已经发货，未退款
        if (petOrder != null
                && OrderStateEnum.PAY_PAID.getState() == petOrder.getPaymentState()
                && OrderStateEnum.DRIVER_DRIVERED.getState() == petOrder.getDriverState()
                && OrderStateEnum.RECEIVE_UN_RECEIVE.getState() == petOrder.getReceiveState()
                && OrderStateEnum.REFUNDS_UN_REFUNDS.getState() == petOrder.getRefundsState()) {
            // 更改收货状态
            return petOrderService.updateReceiveState(orderNo, OrderStateEnum.RECEIVE_RECEIVED.getState());
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deliverOrder(String orderNo, String wayBill) {
        // 获取订单
        PetOrder petOrder = petOrderService.get(orderNo);
        if (petOrder != null) {
            // 更新发货状态
            petOrderService.updateDriverState(orderNo, OrderStateEnum.DRIVER_DRIVERED.getState());
            // 如果没有运单号 则修改运单号
            if (StringUtils.isBlank(petOrder.getWayBill())) {
                petOrderService.updateWayBill(orderNo, wayBill);
            }
        }
        return 1;
    }




    /**
     * <p>
     * 获取宠物价格
     * </p>
     *
     * @param petVo  宠物vo
     * @param buyQty 购买数量
     * @return java.math.BigDecimal
     * @author LiuXiangLin
     * @date 14:47 2020/3/30
     **/
    private BigDecimal getPetPrice(PetVo petVo, int buyQty) {
        if (petVo.getPet().getGroupon() == 1) {
            if (CollectionUtils.isNotEmpty(petVo.getPetGrouponList())) {
                for (PetGroupon groupon : petVo.getPetGrouponList()) {
                    if (buyQty == groupon.getQty()) {
                        return groupon.getPrice();
                    }
                }
            }
            return null;
        } else {
            return petVo.getPet().getRetailPrice();
        }
    }

    /**
     * <p>
     * 设置完整的对象
     * </p>
     *
     * @param petOrderVo 宠物vo对象
     * @return com.yangwang.application.pet.market.model.market.PetOrderVo
     * @author LiuXiangLin
     * @date 16:32 2020/3/30
     **/
    private PetOrderVo addFullObj(PetOrderVo petOrderVo) {
        petOrderVo.setPet(petService.get(petOrderVo.getPet().getPetNo()));
        if (petOrderVo.getCoupon() != null) {
            petOrderVo.setCoupon(couponService.get(petOrderVo.getCoupon().getCouponID()));
        }
        petOrderVo.setReceivingAddress(receivingAddressService.get(petOrderVo.getReceivingAddress().getReceivingNo()));
        return petOrderVo;
    }
}
