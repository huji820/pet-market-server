package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.utils.BeanUtils;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.*;
import com.yangwang.application.pet.market.model.market.PetOrder;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.*;
import com.yangwang.application.pet.market.service.facade.customer.PetOrderService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.JsonUtil;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import com.yangwang.sysframework.utils.network.HttpUtil;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
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
 * @className PetTransportServiceImpl
 * @date 2020/3/26 16:33
 **/
@Service
public class PetTransportServiceImpl implements PetTransportService {
    /**
     * 运输类型请求地址
     */
    private static final String TRANSPORT_TYPE_LIST = "/api/transport/listTransportType";
    /**
     * 获取运输价格
     */
    private static final String TRANSPORT_PRICE = "/api/order/getOrderPrice";

    /**
     * 保存一个运输订单
     */
    private static final String SAVE_TRANSPORT_ORDER = "/api/order/insertOrder";

    /**
     * 支付运输订单
     */
    private static final String PAY_TRANSPORT_ORDER = "/pay/callback/transport";

    /**
     * 获取运输状态
     */
    private static final String GET_ORDER_STATE = "/api/order";

    /**
     * 响应成功key
     */
    private static final String RESPOND_CODE_KEY = "code";

    /**
     * 响应成功返回值key
     */
    private static final String RESPOND_SUCCESS_DATE_KEY = "data";

    /**
     * 价格key
     */
    private static final String PRICE_KEY = "orderAmount";

    /**
     * 响应成功code值
     */
    private static final int RESPOND_SUCCESS_CODE = 200;

    @Value("${transport.server.host}")
    String transportServiceHost;

    @Resource
    HttpUtil httpUtil;

    @Resource
    BusinessService businessService;

    @Resource
    PetService petService;

    @Resource
    PetSortService petSortService;

    @Resource
    PetGenreService petGenreService;

    @Resource
    ReceivingAddressService receivingAddressService;

    @Resource
    PetOrderService petOrderService;

    @Override
    public List<Integer> listTransportType(String startCity, String endCity) {
        try {
            Response response = httpUtil.get(transportServiceHost + TRANSPORT_TYPE_LIST + "?startCity=" + startCity + "&endCity=" + endCity);
            return (List) getRootData(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public BigDecimal getTransportPrice(PetOrderVo petOrderVo) {
        TransportOrderDto transportOrderDto = convertToTransportOrderDto(petOrderVo);
        try {
            Response response = httpUtil.postRequestBody(transportServiceHost + TRANSPORT_PRICE, BeanUtils.beanToMap(transportOrderDto));
            Map<String, Object> resultMap = (Map) getRootData(response);
            if (resultMap != null) {
                return TypeConvertUtil.$BigDecimal(resultMap.get(PRICE_KEY));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String saveTransportOrder(PetOrderVo petOrderVo) {
        TransportOrderDto transportOrderDto = convertToTransportOrderDto(petOrderVo);
        try {
            Response response = httpUtil.postRequestBody(transportServiceHost + SAVE_TRANSPORT_ORDER, BeanUtils.beanToMap(transportOrderDto));
            if (response.isSuccessful()) {
                String respondStr = response.body().string();
                Map<String, Object> resultMap = (Map<String, Object>) JsonUtil.formObject(respondStr);
                if (TypeConvertUtil.$int(resultMap.get(RESPOND_CODE_KEY)) == RESPOND_SUCCESS_CODE) {
                    return TypeConvertUtil.$Str(resultMap.get(RESPOND_SUCCESS_DATE_KEY));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int payOrder(String transportOrderNo) throws IOException {
        String requestUri = transportServiceHost + PAY_TRANSPORT_ORDER + "/" + transportOrderNo;
        httpUtil.get(requestUri);
        return 0;
    }

    @Override
    public Object getOrderState(String orderNo) {
        // 获取订单
        PetOrder petOrder = petOrderService.get(orderNo);
        if (petOrder != null) {
            try {
                Response response = httpUtil.get(transportServiceHost + GET_ORDER_STATE + "/" + petOrder.getWayBill());
                return getRootData(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * <p>
     * 转换为宠物运输对象
     * </p>
     *
     * @param petOrderVo 宠物订单对象
     * @return com.yangwang.application.pet.market.model.common.TransportOrderDto
     * @author LiuXiangLin
     * @date 9:20 2020/3/27
     **/
    private TransportOrderDto convertToTransportOrderDto(PetOrderVo petOrderVo) {
        TransportOrderDto result = new TransportOrderDto();

        // 获取宠物对象
        Pet pet = petService.get(petOrderVo.getPet().getPetNo());

        // 获取卖家
        Business seller = businessService.getByBusinessNoWithOutState(pet.getBusiness().getBusinessNo());

        // 获取收货地址
        ReceivingAddress receivingAddress = receivingAddressService.get(petOrderVo.getReceivingAddress().getReceivingNo());

        // 获取宠物种类
        PetSort petSort = petSortService.get(pet.getPetSort().getPetSortNo());

        // 获取宠物品类
        PetGenre petGenre = petGenreService.get(pet.getPetGenre().getPetGenreNo());

        result.setStartCity(seller.getCity());
        result.setEndCity(receivingAddress.getCity());
        result.setLeaveDate(DateUtil.format(new Date(), DateUtil.FORMAT_SIMPLE));
        result.setNum(petOrderVo.getQty());
        result.setPetType(petSort.getPetSortName());
        result.setPetClassify(petGenre.getPetGenreName());
        result.setWeight(pet.getWeight());
        result.setTransportType(petOrderVo.getTransportType());
        result.setBuyPetCage(1);
        result.setPetAmount(pet.getRetailPrice());
        result.setSenderName(seller.getBusinessName());
        result.setSenderPhone(seller.getContactPhone());
        result.setReceiverName(receivingAddress.getContacts());
        result.setReceiverPhone(receivingAddress.getPhone());
        result.setCustomerNo(seller.getCustomerNo());
        result.setGiveFood(1);
        result.setGuarantee(1);

        return result;
    }

    private Object getRootData(Response response) throws Exception {
        if (response.isSuccessful()) {
            String respondStr = response.body().string();
            Map<String, Object> resultMap = (Map<String, Object>) JsonUtil.formObject(respondStr);
            if (TypeConvertUtil.$int(resultMap.get(RESPOND_CODE_KEY)) == RESPOND_SUCCESS_CODE) {
                return resultMap.get(RESPOND_SUCCESS_DATE_KEY);
            }
        }
        return null;
    }
}
