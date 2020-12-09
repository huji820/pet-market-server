package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.service.facade.service.ServicePetHairService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/service/hair")
@Api(description = "服务毛发长度（1为短毛，2为长毛")
public class ServicePetHairController {

    @Autowired
    ServicePetHairService servicePetHairService;

    @GetMapping()
    public JsonResult listPetHair(long serviceID, String petGenreNo) {
        return JsonResult.success(servicePetHairService.listServicePetHair(serviceID, petGenreNo));
    }

    @ApiOperation("获取所有的宠物毛长")
    @GetMapping("list")
    public JsonResult listAllPetHair() {
        return JsonResult.success(servicePetHairService.listAllServicePetHair());
    }


}
