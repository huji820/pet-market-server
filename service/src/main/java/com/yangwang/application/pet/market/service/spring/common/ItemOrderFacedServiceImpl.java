package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.MessageTypeEnum;
import com.yangwang.application.pet.market.common.enums.OrderStateEnum;
import com.yangwang.application.pet.market.common.enums.WeChatPayCallBackEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.BaseUnifiedPay;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.common.ItemGroupon;
import com.yangwang.application.pet.market.model.common.ReceivingAddress;
import com.yangwang.application.pet.market.model.common.coupon.Coupon;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.market.ItemOrderInfo;
import com.yangwang.application.pet.market.model.vo.ItemOrderInfoVo;
import com.yangwang.application.pet.market.model.vo.ItemOrderVo;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.model.vo.OrderPriceVo;
import com.yangwang.application.pet.market.service.facade.common.*;
import com.yangwang.application.pet.market.service.facade.coupon.CouponFacedService;
import com.yangwang.application.pet.market.service.facade.coupon.CouponService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.application.pet.market.service.spring.factory.CouponFactoryProducer;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderFacedServiceImpl
 * @date 2020/3/31 10:43
 **/
@Service
public class ItemOrderFacedServiceImpl implements ItemOrderFacedService {
    @Resource
    ItemDetailService itemDetailService;

    @Resource
    CouponService couponService;

    @Resource
    CouponFacedService couponFacedService;

    @Resource
    CouponFactoryProducer<ItemOrder> couponFactoryProducer;

    @Resource
    BusinessService businessService;

    @Resource
    ReceivingAddressService receivingAddressService;

    @Resource
    ItemOrderService itemOrderService;

    @Resource
    AccountService accountService;

    @Resource
    SMSMessageReminderService smsMessageReminderService;

    @Resource(name = "PushItemService")
    MessagePushService messagePushService;

    @Value("${localHost}")
    String localHost;

    @Resource
    ItemService itemService;

    @Resource
    ItemOrderInfoService itemOrderInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long save(ItemOrderVo itemOrderVo) {
        //生成商品订单
        ItemOrder itemOrder = convertToItemOrder(itemOrderVo);
        //生成商品订单详情信息
        List<ItemOrderInfo> orderInfoList = itemOrder.getItemOrderInfoList();

        if(orderInfoList.size() != 1){  //商品页购买，商品种类为1，可能存在代发
            ItemVo itemVo = itemDetailService.get(orderInfoList.get(0).getItemNo());
            if(itemVo.getItem().getSourceItemNo() != null){    //不是源头商品
                if(itemOrderVo.getShareBusiness() == null){     //没有分享分销人
                    //把当前商家设置成分享分销人
                    itemOrderVo.setShareBusiness(itemVo.getItem().getBusiness());
                }
                //获取源头商品，替代当前商品
                Item item = itemService.get(TypeConvertUtil.$int(itemVo.getItem().getSourceItemNo()));
                orderInfoList.get(0).setItemNo(item.getItemNo());
                orderInfoList.get(0).setShopNo(item.getBusiness().getBusinessNo());
            }
        }

        // 获取买家
        Business buyer = businessService.getByBusinessNoWithOutState(itemOrder.getBuyer().getBusinessNo());
        itemOrder.setBuyer(buyer);

        //获取分销员
        Business shareBusiness = null;
        if(itemOrder.getDistributor() != null){
            shareBusiness = businessService.getByBusinessNoWithOutState(itemOrder.getDistributor().getBusinessNo());
            itemOrder.setDistributor(shareBusiness);
        }

        // 获取收货地址,收货地址可以为null
        ReceivingAddress receivingAddress;
        if(itemOrderVo.getReceivingAddress() == null || itemOrderVo.getReceivingAddress().getReceivingNo() == null){
            receivingAddress = null;
        }else{
            receivingAddress = receivingAddressService.get(itemOrderVo.getReceivingAddress().getReceivingNo());
        }
        itemOrderVo.setReceivingAddress(receivingAddress);

        // 获取价格
        OrderPriceVo orderPriceVo = getPrice(itemOrderVo);

        // 获取优惠券金额
        if (itemOrderVo.getCoupon() != null) {
            Coupon coupon = couponFacedService.getUseful(itemOrderVo.getCoupon().getCouponID());
            itemOrderVo.setCoupon(coupon);
            if (coupon != null) {
                BigDecimal couponDisCountAmount = couponFactoryProducer
                        .getFactory(itemOrder)
                        .getCouponItemService(coupon.getCouponType()).calcDisCount(itemOrderVo);
                if (couponDisCountAmount != null) {
                    // 修改优惠券状态
                    couponService.updateUsedState(coupon.getCouponID(), true);
                    itemOrder.setCouponAmount(couponDisCountAmount);
                }
            }
        }

        // 校验价格
        //orderPriceVo.checkSame(itemOrderVo);
        //支付金额 = 商品价格 - 优惠券金额 + 运费
        itemOrder.setPaymentAmount(itemOrder.getOriginalAmount()
                .subtract(itemOrder.getCouponAmount())
                .add(itemOrder.getCarriage()));
        // 商家金额 = (支付金额 - 运费 - 分销金额 - 成本金额)
        itemOrder.setShopAmount(itemOrder.getPaymentAmount()
                .subtract(itemOrder.getCarriage())
                .subtract(itemOrder.getDistributorAmount())
                .subtract(itemOrder.getCostAmount()));
        itemOrderService.save(itemOrder);
        for(ItemOrderInfo itemOrderInfo : itemOrder.getItemOrderInfoList()){
            itemOrderInfoService.save(itemOrderInfo);
        }


        // TODO 支付订单 上线时需要删除
//        try {
//            payCallBack(orderNo);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return TypeConvertUtil.$Long(itemOrder.getOrderNo());
    }

    @Override
    public OrderPriceVo getPrice(ItemOrderVo itemOrderVo) {
        OrderPriceVo result = new OrderPriceVo();

        ItemOrder itemOrder = convertToItemOrder(itemOrderVo);

        result.setQty(itemOrder.getItemOrderInfoList().size());

//        if (itemOrder.getOriginalAmount() != null && itemOrder.getBuyer().getAuthType() > 1) {
//            result.setGoodsPrice(price);
//            result.setGoodsAmount(price.multiply(BigDecimal.valueOf(itemOrderVo.getQty())));
//        } else {
//            result.setGoodsPrice(itemVo.getItem().getRetailPrice());
//            result.setGoodsAmount(itemVo.getItem().getRetailPrice().multiply(BigDecimal.valueOf(itemOrderVo.getQty())));
//        }
//        itemOrderVo.setItem(itemVo.getItem());
//        itemOrderVo.setGoodsPrice(result.getGoodsPrice());
//        itemOrderVo.setGoodsAmount(result.getGoodsAmount());
        result.setGoodsAmount(itemOrder.getOriginalAmount());
        // 获取优惠券
        BigDecimal couponDisCountAmount = BigDecimal.ZERO;
        if (itemOrderVo.getCoupon() != null) {
            Coupon coupon = couponFacedService.getUseful(itemOrderVo.getCoupon().getCouponID());
            if (coupon != null) {
                itemOrderVo.setCoupon(coupon);
                couponDisCountAmount = couponFactoryProducer
                        .getFactory(itemOrder)
                        .getCouponItemService(coupon.getCouponType()).calcDisCount(itemOrderVo);

            } else {
                result.setPriceState(OrderPriceVo.ERROR_COUPON);
            }
        }

        if (couponDisCountAmount == null) {
            result.setPriceState(OrderPriceVo.ERROR_COUPON);
            return result;
        }

        result.setCouponDiscountAmount(couponDisCountAmount);

        // 运费为包邮 价格为0
        result.setTransportAmount(BigDecimal.ZERO);

        // 计算支付价格
        result.setPaymentAmount(result.calcPaymentAmount());

        result.setPriceState(OrderPriceVo.SUCCESS_CALC);

        return result;
    }

    @Override
    public Map<String, String> getPayParam(String orderNo, String ipAddress) throws Exception {
        // 获取订单
        ItemOrder itemOrder = itemOrderService.get(orderNo);
        if (itemOrder != null && OrderStateEnum.PAY_UNPAID.getState() == itemOrder.getPaymentState()) {
            return accountService.unifiedPay(new BaseUnifiedPay() {
                @Override
                public String getOutTradeNo() {
                    return itemOrder.getOutTradeNo();
                }

                @Override
                public Business getSeller() {
                    return itemOrder.getShop();
                }

                @Override
                public Business getBuyer() {
                    return itemOrder.getBuyer();
                }

                @Override
                public Business getDistributor() {
                    return itemOrder.getDistributor();
                }

                @Override
                public String getNotifyUrl() {
                    System.out.println("获取商品回调地址:"+(WeChatPayCallBackEnum.ITEM_ORDER.getCompleteCallBackUrl(localHost, String.valueOf(itemOrder.getOrderNo()))));
                    return WeChatPayCallBackEnum.ITEM_ORDER.getCompleteCallBackUrl(localHost, String.valueOf(itemOrder.getOrderNo()));
                }

                @Override
                public String getBody() {
                    return WeChatPayCallBackEnum.ITEM_ORDER.getParamBody();
                }

                @Override
                public BigDecimal getTotalFee() {
                    return itemOrder.getPaymentAmount();
                }

                @Override
                public BigDecimal getUsedBalance() {
                    return BigDecimal.ZERO;
                }

                @Override
                public int getPoint() {
                    return itemOrder.getPaymentAmount().intValue();
                }

                @Override
                public Coupon getUsedCoupon() {
                    return itemOrder.getCoupon();
                }

                @Override
                public BigDecimal getUsedCouponAmount() {
                    return itemOrder.getCouponAmount();
                }

                @Override
                public BigDecimal getBrokerage() {
                    return itemOrder.getDistributorAmount();
                }

                @Override
                public String getIpAddress() {
                    return ipAddress;
                }

                @Override
                public String getOrderNo() {
                    return itemOrder.getOrderNo();
                }

                @Override
                public BigDecimal getShopAmount() {
                    return itemOrder.getShopAmount();
                }
            });
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int payCallBack(String orderNo) throws Exception {
        // 获取订单
        ItemOrder itemOrder = itemOrderService.get(orderNo);
        //获取订单商品信息
        List<ItemOrderInfo> orderInfoList = itemOrder.getItemOrderInfoList();
        // 订单状态校验
        if (itemOrder != null && OrderStateEnum.PAY_UNPAID.getState() == itemOrder.getPaymentState()) {
            // 买家
            Business buyer = businessService.getByBusinessNoWithOutState(itemOrder.getBuyer().getBusinessNo());

            // 卖家
            Business shop = businessService.getByBusinessNoWithOutState(itemOrder.getShop().getBusinessNo());

            // 分销商
            Business distributor = itemOrder.getDistributor() == null ? null : businessService.getByBusinessNoWithOutState(itemOrder.getDistributor().getBusinessNo());

            // 修改订单状态
            itemOrderService.updatePaymentState(orderNo, OrderStateEnum.PAY_PAID.getState());

            // 积分等
            accountService.unifiedOrder(new BaseUnifiedPay() {
                @Override
                public String getOutTradeNo() {
                    return itemOrder.getOutTradeNo();
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
                    return itemOrder.getPaymentAmount();
                }

                @Override
                public BigDecimal getUsedBalance() {
                    return BigDecimal.ZERO;
                }

                @Override
                public int getPoint() {
                    return itemOrder.getPaymentAmount().intValue();
                }

                @Override
                public Coupon getUsedCoupon() {
                    return itemOrder.getCoupon();
                }

                @Override
                public BigDecimal getUsedCouponAmount() {
                    return itemOrder.getCouponAmount();
                }

                @Override
                public BigDecimal getBrokerage() {
                    return itemOrder.getDistributorAmount();
                }

                @Override
                public String getIpAddress() {
                    return null;
                }

                @Override
                public String getOrderNo() {
                    return itemOrder.getOrderNo();
                }

                @Override
                public BigDecimal getShopAmount() {
                    return itemOrder.getPaymentAmount();
                }
            });

            for(ItemOrderInfo itemOrderInfo : orderInfoList){
                // 回写商品销量
                itemService.updateSalesVolumeAdd(itemOrderInfo.getItemNo(), 1);

                //商品库存减购买的数量
                itemService.updateQty(itemOrderInfo.getItemNo(), itemOrderInfo.getQty());

                //给商家发送站内信提示
                messagePushService.messagePushBusiness(Integer.toString(itemOrderInfo.getItemNo()), MessageTypeEnum.COMMODITY_SALESTIPS.getType(),orderNo);

                //给关注了该商品的用户发送站内信消息
                messagePushService.messagePush(Integer.toString(itemOrderInfo.getItemNo()), MessageTypeEnum.COMMODITY_SOLD.getType());

            }

            //给商家发送商品售出短信提示
            smsMessageReminderService.sendMsgToBusiness(shop.getContactPhone());

        }
        return 0;
    }

    @Override
    public void cancelUnpaidOrder() {
        // 获取24小时前的时间
        String yesterday = DateUtil.formatFull(DateUtil.getAddHourDate(new Date(), -24 * 2));
        // 修改24小时前未支付的订单
        itemOrderService.cancelUnpaidOrder(yesterday);
    }

    @Override
    public int signForOrder(String orderNo) {
        // 获取订单
        ItemOrder itemOrder = itemOrderService.get(orderNo);
        if (itemOrder != null
                && OrderStateEnum.PAY_PAID.getState() == itemOrder.getPaymentState()
                && OrderStateEnum.DRIVER_DRIVERED.getState() == itemOrder.getDriverState()
                && OrderStateEnum.RECEIVE_UN_RECEIVE.getState() == itemOrder.getReceiveState()
                && OrderStateEnum.REFUNDS_UN_REFUNDS.getState() == itemOrder.getRefundsState()) {
            // 修改签收装填
            return itemOrderService.updateReceiveState(orderNo, OrderStateEnum.RECEIVE_RECEIVED.getState());
        }

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deliverForOrder(String orderNo, String wayBill, String expressCompany) {
        // 获取订单
        ItemOrder itemOrder = itemOrderService.get(orderNo);
        if (itemOrder != null) {
            // 修改订单发货状态
            itemOrderService.updateDriverState(orderNo, OrderStateEnum.DRIVER_DRIVERED.getState(), expressCompany);
            // 如果有订单号则不更新
            if (StringUtils.isBlank(itemOrder.getWayBill())) {
                itemOrderService.updateWayBill(orderNo, wayBill);
            }
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateOrderPrice(String orderNo, BigDecimal price) {
        // 获取订单
        ItemOrder itemOrder = itemOrderService.get(orderNo);
        // 如果订单金额没有改变则不修改订单支付
        if (itemOrder != null && itemOrder.getPaymentAmount().compareTo(price) != 0) {
            // 重新生成outTradeNo
            itemOrder.setOutTradeNo(DateUtil.format(new Date(), "yyyyMMddHHmmss") + (int)(Math.random()*1000));
            itemOrder.setPaymentAmount(price);
            // itemOrderService.getOrderPaymentAmount(itemOrder);
            return itemOrderService.updateOrderPrice(itemOrder);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int uploadPaymentVoucher(String orderNo, String paymentVoucher) {
        ItemOrder order = itemOrderService.get(orderNo);
        //订单待付款状态下才可上传收款凭证
        if(OrderStateEnum.PAY_UNPAID.getState() == order.getPaymentState()){
            // 添加支付凭证
            int i = itemOrderService.uploadPaymentVoucher(orderNo, paymentVoucher);
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

    /**
     * @Description: 把商品订单信息vo转化为商品订单信息
     * @Author: zxj
     * @Date: 2020/9/3 16:37
     * @param itemOrderInfoVo: 商品订单信息vo
     * @return: com.yangwang.application.pet.market.model.market.ItemOrderInfo
     **/
    private ItemOrderInfo convertToItemOrderInfo(ItemOrderInfoVo itemOrderInfoVo, String buyerNo){
        ItemOrderInfo itemOrderInfo = new ItemOrderInfo();
        // 获取商品
        System.out.println(itemOrderInfoVo.getItem().getItemNo());
        ItemVo itemVo = itemDetailService.get(itemOrderInfoVo.getItem().getItemNo());
        if(itemVo == null || itemVo.getItem() == null){
            return null;
        }
        //获取商品
        Item item = itemVo.getItem();
        //计算分销金额  分销金额 = 商品金额 * 佣金比例 / 100
        BigDecimal distributorAmount = getStepPrice(itemVo,itemOrderInfoVo.getQty())
                .multiply(item.getCommission())
                .divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP, 2);
        //获取买家
        Business buyer = businessService.getByBusinessNoWithOutState(buyerNo);
        //获取团购价格
        BigDecimal stepPrice = getStepPrice(itemVo, itemOrderInfoVo.getQty());
        //判断买家是否是认证商家，如果不是无法享受团购价
        if(stepPrice != null&&buyer.getAuthType()>1){
            itemOrderInfo.setPrice(stepPrice.multiply(BigDecimal.valueOf(itemOrderInfoVo.getQty())));
        }else{
            itemOrderInfo.setPrice(item.getRetailPrice().multiply(BigDecimal.valueOf(itemOrderInfoVo.getQty())));
        }
        itemOrderInfo.setItemNo(item.getItemNo());
        itemOrderInfo.setShopNo(item.getBusiness().getBusinessNo());
        itemOrderInfo.setDistributorNo(null);
        itemOrderInfo.setDistributorAmount(distributorAmount.multiply(BigDecimal.valueOf(itemOrderInfoVo.getQty())));
        itemOrderInfo.setQty(itemOrderInfoVo.getQty());
        itemOrderInfo.setUnitPrice(stepPrice);
        itemOrderInfo.setCostPrice(item.getCostPrice()==null?BigDecimal.ZERO:(item.getCostPrice().multiply(BigDecimal.valueOf(itemOrderInfoVo.getQty()))));
        itemOrderInfo.setItemName(item.getItemName());
        itemOrderInfo.setPetSortNo(item.getPetSort().getPetSortNo());
        itemOrderInfo.setPetBrandNo(item.getItemBrand()==null?null:item.getItemBrand().getItemBrandNo());
        itemOrderInfo.setBarCode(item.getBarCode());
        itemOrderInfo.setGrossWeight(item.getGrossWeight());
        itemOrderInfo.setItemValidity(item.getItemValidity());
        itemOrderInfo.setPetGenreStr(item.getPetGenreStr());
        itemOrderInfo.setCoverImg(item.getCoverImg());
        return itemOrderInfo;
    }

    /**
     * @Description:  把商品订单vo转化为商品订单
     * @Author: zxj
     * @Date: 2020/9/3 16:11
     * @param itemOrderVo: 商品订单vo
     * @return: com.yangwang.application.pet.market.model.market.ItemOrder
     **/
    public ItemOrder convertToItemOrder(ItemOrderVo itemOrderVo){
        ItemOrder itemOrder = new ItemOrder();
        List<ItemOrderInfo> itemOrderInfoList = new ArrayList<>();
        BigDecimal originalAmount = BigDecimal.ZERO;
        BigDecimal costAmount = BigDecimal.ZERO;
        BigDecimal distributorAmount = BigDecimal.ZERO;
        //生成商品订单no
        Long itemOrderNo = System.currentTimeMillis();

        Integer freeShipping = 1;
        for(ItemOrderInfoVo itemOrderInfoVo : itemOrderVo.getItemOrderInfoVos()){
            //如果有一个商品不包邮，该笔订单不包邮
            if(itemOrderInfoVo.getItem() != null
                    && itemOrderInfoVo.getItem().getFreeShipping() != null
                    && itemOrderInfoVo.getItem().getFreeShipping() == 0){
                freeShipping = 0;
            }
            ItemOrderInfo itemOrderInfo = convertToItemOrderInfo(itemOrderInfoVo, itemOrderVo.getBuyer().getBusinessNo());
            itemOrderInfo.setOrderNo(TypeConvertUtil.$Str(itemOrderNo));
            //计算总价
            originalAmount = originalAmount.add(itemOrderInfo.getPrice());
            //计算总成本价
            costAmount = costAmount.add(itemOrderInfo.getCostPrice());
            //计算总分销金额
            distributorAmount = distributorAmount.add(itemOrderInfo.getDistributorAmount());
            //添加订单商品详情
            itemOrderInfoList.add(itemOrderInfo);
        }

        itemOrder.setOrderNo(TypeConvertUtil.$Str(itemOrderNo));
        itemOrder.setShop(itemOrderVo.getSeller());
        itemOrder.setBuyer(itemOrderVo.getBuyer());
        itemOrder.setDistributor(itemOrderVo.getShareBusiness());
        itemOrder.setCreateDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
        itemOrder.setCreateTime(DateUtil.format(new Date(), DateUtil.FORMAT_TIME));
        itemOrder.setTotalNum(itemOrderVo.getItemOrderInfoVos().size());
        itemOrder.setCoupon(itemOrderVo.getCoupon());
        itemOrder.setCouponAmount(itemOrderVo.getCouponDisCountAmount());
        itemOrder.setCarriage(BigDecimal.ZERO);
        itemOrder.setFreeShipping(freeShipping);
        itemOrder.setOriginalAmount(originalAmount);
        itemOrder.setPaymentAmount(BigDecimal.ZERO);
        itemOrder.setDistributorAmount(distributorAmount);
        itemOrder.setCouponAmount(BigDecimal.ZERO);
        itemOrder.setBuyerName(itemOrderVo.getReceivingAddress()==null?null:itemOrderVo.getReceivingAddress().getContacts());
        itemOrder.setBuyerAddress(itemOrderVo.getReceivingAddress()==null?null:itemOrderVo.getReceivingAddress().getProvince() + itemOrderVo.getReceivingAddress().getCity() + itemOrderVo.getReceivingAddress().getCounty() + itemOrderVo.getReceivingAddress().getDetailedAddress());
        itemOrder.setBuyerPhone(itemOrderVo.getReceivingAddress()==null?null:itemOrderVo.getReceivingAddress().getPhone());
        itemOrder.setPaymentState(OrderStateEnum.PAY_UNPAID.getState());
        itemOrder.setDriverState(OrderStateEnum.DRIVER_UN_DRIVER.getState());
        itemOrder.setReceiveState(OrderStateEnum.RECEIVE_UN_RECEIVE.getState());
        itemOrder.setEvaluateState(OrderStateEnum.EVALUATE_UN_EVALUATE.getState());
        itemOrder.setRefundsState(OrderStateEnum.REFUNDS_UN_REFUNDS.getState());
        itemOrder.setOutTradeNo(TypeConvertUtil.$Str(itemOrderNo));
        itemOrder.setCostAmount(costAmount);
        itemOrder.setShippingMethods(itemOrderVo.getShippingMethods());
        itemOrder.setItemOrderInfoList(itemOrderInfoList);
        return itemOrder;
    }

    private BigDecimal getPetPrice(ItemVo itemVo, int qty) {
        if (itemVo.getItem().getGroupon() != null && itemVo.getItem().getGroupon() == 1) {
            int i = 0;
            for (ItemGroupon itemGroupon : itemVo.getItemGrouponList()) {
                if ((itemGroupon.getQty() == qty)) {
                    return itemGroupon.getPrice();
                }
                if (i == itemVo.getItemGrouponList().size() - 1) {
                    throw new RuntimeException("该数量没有匹配的价格");
                }
                i++;
            }
            return null;
        } else {
            return itemVo.getItem().getRetailPrice();
        }
    }

    private BigDecimal getStepPrice(ItemVo itemVo, int qty) {
        BigDecimal tempPrice = itemVo.getItem().getRetailPrice();
        for (int i = 0; i < itemVo.getItemGrouponList().size(); i ++) {
            ItemGroupon itemGroupon = itemVo.getItemGrouponList().get(i);
            if (itemGroupon.getQty() == qty) {
                tempPrice = itemVo.getItemGrouponList().get(i).getPrice();
                break;
            } else if (itemGroupon.getQty() > qty) {
                if (i == 0) {
                    tempPrice = itemVo.getItem().getRetailPrice();
                } else {
                    tempPrice = itemVo.getItemGrouponList().get(i-1).getPrice();
                }
                break;
            }
        }
        return tempPrice;
    }
}

