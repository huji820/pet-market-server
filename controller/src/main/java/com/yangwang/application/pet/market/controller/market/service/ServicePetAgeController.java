package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.service.facade.service.ServicePetAgeService;
import com.yangwang.application.pet.market.service.facade.service.ServicePetWeightService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2020-03-24 22:24
 * @Version 1.0
 */
@RestController()
@RequestMapping("/api/service/age")
@Api(description = "获取服务年龄区间")
public class ServicePetAgeController {

    @Autowired
    ServicePetAgeService servicePetAgeService;

    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "serviceID", value = "服务主键")
    })
    @GetMapping("")
    public JsonResult listPetHair(long serviceID) {
        return JsonResult.success(servicePetAgeService.listServicePetAge(serviceID));
    }
}
