package com.yangwang.application.pet.market.service.spring.customer;

import com.yangwang.application.pet.market.dao.market.pet.PetOrderMapper;
import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.service.facade.customer.PetOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 9:49 2020/3/28
 **/
@Service
public class PetOrderServiceImpl implements PetOrderService {
    @Resource
    PetOrderMapper petOrderMapper;

    @Override
    public int save(PetOrder petOrder) {
        return petOrderMapper.save(petOrder);
    }

    @Override
    public int updatePaymentState(String orderNo, int paymentState) {
        return petOrderMapper.updatePaymentState(orderNo, paymentState);
    }

    @Override
    public int updateDriverState(String orderNo, int driverState) {
        return petOrderMapper.updateDriverState(orderNo, driverState);
    }

    @Override
    public int updateReceiveState(String orderNo, int receiveState) {
        return petOrderMapper.updateReceiveState(orderNo, receiveState);
    }

    @Override
    public int updateEvaluateState(String orderNo, int evaluateState) {
        return petOrderMapper.updateEvaluateState(orderNo, evaluateState);
    }

    @Override
    public int updateRefundsState(String orderNo, int refundsState) {
        return petOrderMapper.updateRefundsState(orderNo, refundsState);
    }

    @Override
    public int updateWayBill(String orderNo, String wayBill) {
        return petOrderMapper.updateWayBill(orderNo, wayBill);
    }

    @Override
    public int updateOutTradeNo(String orderNo, String outTradeNo) {
        return petOrderMapper.updateOutTradeNo(orderNo, outTradeNo);
    }

    @Override
    public int updateRefundNo(String orderNo, String refundNo) {
        return petOrderMapper.updateRefundNo(orderNo, refundNo);
    }

    @Override
    public PetOrder get(String orderNo) {
        return petOrderMapper.get(orderNo);
    }

    @Override
    public int cancelUnpaidOrder(String beforeTime) {
        return petOrderMapper.cancelUnpaidOrder(beforeTime);
    }

    @Override
    public PetOrder getPetOrderByWaybill(String wayBill) {
        return petOrderMapper.getPetOrderByWaybill(wayBill);
    }

    @Override
    public int updateOrderCarriage(BigDecimal carriage, BigDecimal paymentAmount, String orderNo) {
        return petOrderMapper.updateOrderCarriage(carriage, paymentAmount, orderNo);
    }

    @Override
    public int updateOrderPrice(PetOrder petOrder) {
        return petOrderMapper.updateOrderPrice(petOrder);
    }

    @Override
    public int uploadPaymentVoucher(String orderNo, String paymentVoucher) {
        return petOrderMapper.uploadPaymentVoucher(orderNo, paymentVoucher);
    }

}
