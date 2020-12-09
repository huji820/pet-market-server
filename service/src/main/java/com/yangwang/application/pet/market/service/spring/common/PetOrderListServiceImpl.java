package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.dao.market.pet.PetOrderListMapper;
import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.model.params.QueryOrderListParam;
import com.yangwang.application.pet.market.service.facade.common.PetOrderListService;
import com.yangwang.sysframework.utils.network.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetOrderListServiceImpl
 * @date 2020/3/31 15:40
 **/
@Service
public class PetOrderListServiceImpl implements PetOrderListService {
    @Resource
    PetOrderListMapper petOrderListMapper;

    @Resource
    HttpUtil httpUtil;

    @Value("${transport.server.host}")
    String transportServiceHost;

    private static final String DELETE_CONSIGN_ORDER = "/api/order/cancelOrder";

    @Override
    public List<PetOrder> listBuyerOrderByParam(QueryOrderListParam queryOrderListParam) {
        return petOrderListMapper.listBuyerOrderParam(queryOrderListParam);
    }

    @Override
    public List<PetOrder> listShopOrderByParam(QueryOrderListParam queryOrderListParam) {
        return petOrderListMapper.listShopOrderParam(queryOrderListParam);
    }
    //通过宠物订单号删除订单
    @Override
    public int delPetOrderByNO(String orderNo,String buyer_customer_no,String way_bill) {
         int i = petOrderListMapper.delPetOrderByNO(orderNo);
        delTransportOrder(buyer_customer_no,way_bill);
        return i;
    }

    //通过宠物订单编号修改支付价格
    @Override
    public int upPaymentAmount(String orderNo, BigDecimal PaymentAmount) {
        return petOrderListMapper.upPaymentAmount(orderNo,PaymentAmount);
    }

    //通过运单编号和用户编号删除运输订单
    @Override
    public int delTransportOrder(String buyercustomerno, String waybill) {
        try {
            Map<String,Object> map = new HashMap();
            map.put("customerNo",buyercustomerno);
            map.put("orderNo",waybill);
            httpUtil.post(transportServiceHost+DELETE_CONSIGN_ORDER,map);
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}
