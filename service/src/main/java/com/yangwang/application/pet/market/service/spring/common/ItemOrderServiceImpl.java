package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.item.ItemOrderMapper;
import com.yangwang.application.pet.market.model.market.ItemOrder;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderInfoService;
import com.yangwang.application.pet.market.service.facade.common.ItemOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemOrderServiceImpl
 * @date 2020/3/31 18:11
 **/
@Service
public class ItemOrderServiceImpl implements ItemOrderService {
    @Resource
    ItemOrderMapper itemOrderMapper;

    @Resource
    ItemOrderInfoService itemOrderInfoService;

    @Override
    public int save(ItemOrder itemOrder) {
        return itemOrderMapper.save(itemOrder);
    }

    @Override
    public int updatePaymentState(String orderNo, int paymentState) {
        return itemOrderMapper.updatePaymentState(orderNo, paymentState);
    }

    @Override
    public int updateDriverState(String orderNo, int driverState, String expressCompany) {
        return itemOrderMapper.updateDriverState(orderNo, driverState, expressCompany);
    }

    @Override
    public int updateReceiveState(String orderNo, int receiveState) {
        return itemOrderMapper.updateReceiveState(orderNo, receiveState);
    }

    @Override
    public int updateEvaluateState(String orderNo, int evaluateState) {
        return itemOrderMapper.updateEvaluateState(orderNo, evaluateState);
    }

    @Override
    public int updateRefundsState(String orderNo, int refundsState) {
        return itemOrderMapper.updateRefundsState(orderNo, refundsState);
    }

    @Override
    public int updateWayBill(String orderNo, String wayBill) {
        return itemOrderMapper.updateWayBill(orderNo, wayBill);
    }

    @Override
    public int updateOutTradeNo(String orderNo, String outTradeNo) {
        return itemOrderMapper.updateOutTradeNo(orderNo, outTradeNo);
    }

    @Override
    public int updateRefundNo(String orderNo, String refundNo) {
        return itemOrderMapper.updateRefundNo(orderNo, refundNo);
    }

    @Override
    public ItemOrder get(String orderNo) {
        ItemOrder itemOrder = itemOrderMapper.get(orderNo);
        if(itemOrder == null){
            return null;
        }
        itemOrder.setItemOrderInfoList(itemOrderInfoService.listByOrderNo(orderNo));
        return itemOrder;
    }

    @Override
    public int cancelUnpaidOrder(String beforeDateTime) {
        return itemOrderMapper.cancelUnpaidOrder(beforeDateTime);
    }

    @Override
    public int updateOrderPrice(ItemOrder itemOrder) {
        return itemOrderMapper.updateOrderPrice(itemOrder);
    }

    @Override
    public int uploadPaymentVoucher(String orderNo, String paymentVoucher) {
        return itemOrderMapper.uploadPaymentVoucher(orderNo, paymentVoucher);
    }
}
