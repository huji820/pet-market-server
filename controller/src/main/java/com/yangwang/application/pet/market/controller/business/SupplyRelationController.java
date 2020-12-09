package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.facade.business.SupplyRelationService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhouxiaojian
 * @Date 2020/8/21 15:03
 * @Version 1.0
 */
@Api(description = "厂家与分仓")
@RestController
@RequestMapping("/api/manufactor")
public class SupplyRelationController {

    @Resource
    SupplyRelationService supplyRelationService;

    /**
     * 添加分仓
     * @param businessNoList  分仓编号集合
     * @param manufactorNo  厂家编号
     * @return
     */
    @ApiOperation("添加分仓")
    @PostMapping("/addSubWarehouse")
    public JsonResult addSubWarehouse(@RequestParam("businessNo")List<String> businessNoList,
                                      @RequestParam("manufactorNo")String manufactorNo){
        int i = supplyRelationService.addSubWarehouse(businessNoList, manufactorNo);
        return JsonResult.success(i>0?true:false);
    }

    @ApiOperation("通过分仓编号获取所有相关厂家")
    @GetMapping("/listManufactor")
    public JsonResult listManufactor(@RequestParam("businessNo")String businessNo){
        List<Business> businessList = supplyRelationService.listManufactor(businessNo);
        return JsonResult.success(businessList);
    }

    @ApiOperation("通过厂家编号获取所有分仓")
    @GetMapping("/listSubWarehouse")
    public JsonResult listSubWarehouse(@RequestParam("businessNo")String businessNo){
        List<Business> businessList = supplyRelationService.listSubWarehouse(businessNo);
        return JsonResult.success(businessList);
    }
}
