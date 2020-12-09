package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.common.utils.RequestUtils;
import com.yangwang.application.pet.market.model.market.ServiceOrder;
import com.yangwang.application.pet.market.service.facade.service.ServiceOrderService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-28 10:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/service/order")
@Api(description = "服务订单controller")
public class ServiceOrderController {

    @Autowired
    ServiceOrderService serviceOrderService;

    @ApiOperation(value = "提交订单")
    @PostMapping()
    public JsonResult pay(@RequestBody ServiceOrder serviceOrder, HttpServletRequest httpRequest) throws Exception {
        return JsonResult.success(serviceOrderService.insertOrder(serviceOrder, RequestUtils.getAddress(httpRequest)));
    }

    @ApiOperation(value = "商家查询预约列表")
    @GetMapping("list/shop")
    public JsonResult shopOrders(String businessNo, int offset, int limit) throws Exception {
        return JsonResult.success(serviceOrderService.listOrdersByShop(businessNo, offset, limit));
    }

    @ApiOperation(value = "买家查询预约列表")
    @GetMapping("list/buyer")
    public JsonResult buyerOrders(String businessNo, int offset, int limit) throws Exception {
        List<ServiceOrder> serviceOrderList = serviceOrderService.listOrderByBusiness(businessNo, offset, limit);
        return JsonResult.success(serviceOrderList);
    }

    /**
     * 核销服务订单
     *
     * @param orderNo
     * @return com.yangwang.sysframework.utils.JsonResult
     * @author yang hituzi
     * @date 9:56 2020/4/2
     */
    @PutMapping("/updateVerifyState")
    public JsonResult updateVerifyState(@RequestParam("orderNo") String orderNo) {
        return JsonResult.success(serviceOrderService.updateVerifyState(orderNo));
    }
}
