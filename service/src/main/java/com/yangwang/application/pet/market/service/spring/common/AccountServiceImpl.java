package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.AppTypeEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.business.Distribution;
import com.yangwang.application.pet.market.model.common.BaseUnifiedPay;
import com.yangwang.application.pet.market.model.common.CustomerOpenId;
import com.yangwang.application.pet.market.model.common.Item;
import com.yangwang.application.pet.market.model.market.CreditFlow;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.model.market.ItemOrderInfo;
import com.yangwang.application.pet.market.service.facade.business.BusinessBalanceService;
import com.yangwang.application.pet.market.service.facade.common.AccountService;
import com.yangwang.application.pet.market.service.facade.common.CustomerOpenIdService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderService;
import com.yangwang.application.pet.market.service.facade.common.ItemService;
import com.yangwang.application.pet.market.service.facade.customer.CustomerService;
import com.yangwang.application.pet.market.service.facade.customer.PetOrderService;
import com.yangwang.application.pet.market.service.facade.market.CreditFlowService;
import com.yangwang.application.pet.market.service.facade.service.DistributionService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.wechat.boot.template.WxTemplateUtil;
import com.yangwang.sysframework.wechat.pay.WXPay;
import com.yangwang.sysframework.wechat.pay.WxPayBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author HuJi
 * @date 10:06 2020/3/26
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    WXPay wxPay;

    @Autowired
    CreditFlowService creditFlowService;

    @Autowired
    CustomerOpenIdService customerOpenIdService;

    @Autowired
    WxTemplateUtil wxTemplateUtil;

    @Autowired
    BusinessService businessService;

    @Resource
    BusinessBalanceService businessBalanceService;

    @Autowired
    DistributionService distributionService;

    @Resource
    ItemOrderService itemOrderService;

    @Resource
    PetOrderService petOrderService;

    @Resource
    ItemService itemService;

    @Resource
    CustomerService customerService;

    @Override
    public Map<String, String> unifiedPay(BaseUnifiedPay pay) throws Exception {
        // 获取openid
        CustomerOpenId customerOpenId = customerOpenIdService.getByCustomerNoAndType(pay.getBuyer().getCustomerNo(), AppTypeEnum.WE_APP_MARKET);

        return wxPay.pay(new WxPayBody(customerOpenId == null ? null : customerOpenId.getOpenId(), pay.getNotifyUrl(), pay.getOutTradeNo(), pay.getBody(), pay.getTotalFee(), pay.getIpAddress()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int unifiedOrder(BaseUnifiedPay pay) {
        Business buyer = businessService.getByBusinessNoWithOutState(pay.getBuyer().getBusinessNo());

        Business shop = businessService.getByBusinessNoWithOutState(pay.getSeller().getBusinessNo());

        Business distributor = pay.getDistributor() == null ? null : businessService.getByBusinessNoWithOutState(pay.getDistributor().getBusinessNo());

        //推荐人编号，为null表示没有推荐人
        String recommenderNo = customerService.getBusinessReferee(buyer.getCustomerNo());
        Business recommender = recommenderNo==null?null:businessService.getByBusinessNoWithOutState(recommenderNo);

        Business manufactor = null;
        ItemOrder itemOrder = itemOrderService.get(pay.getOrderNo());
        if(itemOrder != null){
            List<ItemOrderInfo> orderInfoList = itemOrder.getItemOrderInfoList();

            for(ItemOrderInfo itemOrderInfo : orderInfoList){
                Item item = itemService.get(itemOrderInfo.getItemNo());
                if(item.getManufactor() != null){
                    manufactor = businessService.getByBusinessNoWithOutState(item.getManufactor());
                }
                //如果有厂家，厂家获取商品进货价
                if(manufactor != null){
                    businessBalanceService.saveRebateAmount(String.valueOf(pay.getOrderNo()), manufactor, itemOrderInfo.getCostPrice());
                }
            }

        }

        // 给买家添加积分
        creditFlowService.save(new CreditFlow(buyer, DateUtil.formatFull(new Date()),
                pay.getPoint(), pay.getPoint() + buyer.getCredit(), String.valueOf(pay.getOrderNo()), "", ""));
        businessService.updateCreditAdd(buyer.getBusinessNo(), pay.getPoint());

        // 添加卖家余额
        businessBalanceService.saveRebateAmount(String.valueOf(pay.getOrderNo()), shop, pay.getShopAmount());

        //如果有推荐人和分销商，平分订单分销金额，如果推荐人是站点，分销金额给站点账户
        //如果只有推荐人或只有分销商，获取订单全部分销金额
        //如果没有推荐人和分销商，订单分销金额归卖家所有

        //买家推荐人获取分销金额

        // 如果有佣金
        if (BigDecimal.ZERO.compareTo(pay.getBrokerage()) < 0) {
            //如果有分销商和推荐人
            if(distributor != null && recommender != null){
                //分销商和推荐人平分返利金额
                //为分销商返利
                distributionRebate(buyer,shop,distributor, pay.getTotalFee(), pay.getBrokerage().divide(BigDecimal.valueOf(2)), pay.getOrderNo());
                //为推荐人返利
                distributionRebate(buyer, shop, recommender, pay.getTotalFee(), pay.getBrokerage().divide(BigDecimal.valueOf(2)), pay.getOrderNo());
            }else if(distributor != null && recommender == null){   //如果只有分销商
                //为分销商返利全部返利金额
                distributionRebate(buyer,shop,distributor, pay.getTotalFee(), pay.getBrokerage(), pay.getOrderNo());
            }else if(recommender != null && distributor == null){  //如果只有推荐人
                //为推荐人返利全部返利金额
                distributionRebate(buyer, shop, recommender, pay.getTotalFee(), pay.getBrokerage(), pay.getOrderNo());
            }else{ // 不存在分销商和推荐人
                businessBalanceService.saveRebateAmount(String.valueOf(pay.getOrderNo()), shop, pay.getBrokerage());
            }

        }
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void petOrder(BaseUnifiedPay pay) {
        Business buyer = businessService.getByBusinessNoWithOutState(pay.getBuyer().getBusinessNo());

        Business shop = businessService.getByBusinessNoWithOutState(pay.getSeller().getBusinessNo());

        Business distributor = pay.getDistributor() == null ? null : businessService.getByBusinessNoWithOutState(pay.getDistributor().getBusinessNo());

        // 推荐人编号，为null表示没有推荐人
        String recommenderNo = customerService.getBusinessReferee(buyer.getCustomerNo());
        Business recommender = recommenderNo == null ? null:businessService.getByBusinessNoWithOutState(recommenderNo);

      /*Business manufactor = null;
        PetOrder petOrder = petOrderService.get(pay.getOrderNo());

        for(ItemOrderInfo itemOrderInfo : orderInfoList){
            Item item = itemService.get(itemOrderInfo.getItemNo());
            if(item.getManufactor() != null){
                manufactor = businessService.getByBusinessNoWithOutState(item.getManufactor());
            }
            //如果有厂家，厂家获取商品进货价
            if(manufactor != null){
                businessBalanceService.saveRebateAmount(String.valueOf(pay.getOrderNo()), manufactor, itemOrderInfo.getCostPrice());
            }
        }*/

        // 给买家添加积分
        creditFlowService.save(new CreditFlow(buyer, DateUtil.formatFull(new Date()),
                pay.getPoint(), pay.getPoint() + buyer.getCredit(), String.valueOf(pay.getOrderNo()), "", ""));
        businessService.updateCreditAdd(buyer.getBusinessNo(), pay.getPoint());

        // 添加卖家余额
        businessBalanceService.saveRebateAmount(String.valueOf(pay.getOrderNo()), shop, pay.getShopAmount());

        //如果有推荐人和分销商，平分订单分销金额，如果推荐人是站点，分销金额给站点账户
        //如果只有推荐人或只有分销商，获取订单全部分销金额
        //如果没有推荐人和分销商，订单分销金额归卖家所有

        //买家推荐人获取分销金额

        // 如果有佣金
        if (BigDecimal.ZERO.compareTo(pay.getBrokerage()) < 0) {
            // 如果有分销商和推荐人
            if(distributor != null && recommender != null){
                // 分销商和推荐人平分返利金额
                // 为分销商返利
                distributionRebate(buyer,shop,distributor, pay.getTotalFee(), pay.getBrokerage().divide(BigDecimal.valueOf(2)), pay.getOrderNo());
                // 为推荐人返利
                distributionRebate(buyer, shop, recommender, pay.getTotalFee(), pay.getBrokerage().divide(BigDecimal.valueOf(2)), pay.getOrderNo());
            }else{
                // 不存在分销商和推荐人
                businessBalanceService.saveRebateAmount(String.valueOf(pay.getOrderNo()), shop, pay.getBrokerage());
            }
            // 如果只有分销商
            if(distributor != null && recommender == null){
                // 为分销商返利全部返利金额
                distributionRebate(buyer,shop,distributor, pay.getTotalFee(), pay.getBrokerage(), pay.getOrderNo());
            }
            // 如果只有推荐人
            if(recommender != null && distributor == null){
                // 为推荐人返利全部返利金额
                distributionRebate(buyer, shop, recommender, pay.getTotalFee(), pay.getBrokerage(), pay.getOrderNo());
            }
        }
    }

    /**
     * @Description: 为分销商返利和推荐人返利
     * @Author: zxj
     * @Date: 2020/9/7 14:17
     * @param buyer: 买家
     * @param shop: 商家
     * @param distributor: 分销商/推荐人
     * @param totalFee: 总金额
     * @param brokerage: 返利金额
     * @param orderNo: 订单编号
     * @return: void
     **/
    private void distributionRebate(Business buyer, Business shop, Business distributor,
                                    BigDecimal totalFee, BigDecimal brokerage, String orderNo){
        // 添加返利金额
        businessBalanceService.saveRebateAmount(String.valueOf(orderNo), distributor, brokerage);

        // 添加分销记录
        distributionService.save(
                new Distribution.Builder()
                        .buyer(buyer)
                        .seller(shop)
                        .distributor(distributor)
                        .createDate(DateUtil.formatFull(new Date()))
                        .originalAmount(totalFee)
                        .getAmount(brokerage)
                        .linkNo(String.valueOf(orderNo))
                        .build()
        );
    }
}
