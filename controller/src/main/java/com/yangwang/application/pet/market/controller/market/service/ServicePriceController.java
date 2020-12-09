package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.service.facade.service.ServicePriceService;
import com.yangwang.sysframework.utils.EnumResultCode;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-31 1:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/service/price/get")
@Api(description = "服务价格获取")
public class ServicePriceController {

    @Autowired
    ServicePriceService servicePriceService;

    @ApiOperation(value = "获取服务价格")
    @GetMapping("")
    public JsonResult getPrice(Integer petGenreNo, Integer serviceId, Integer hairLength, Integer weight, Integer age) {
        if (petGenreNo == null) {
            return JsonResult.err(EnumResultCode.UNKNOW_EXCEPTION.getCode(), "宠物类型不能为空");
        }

        if (serviceId == null) {
            return JsonResult.err(EnumResultCode.UNKNOW_EXCEPTION.getCode(), "服务不能为空");
        }

        return JsonResult.success(servicePriceService.getServicePrice(petGenreNo, serviceId, hairLength, weight, age));
    }
}
