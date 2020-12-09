package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.service.facade.service.DistributionService;
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
 * @Date 2020-03-24 23:48
 * @Version 1.0
 */
@Api(description = "分销")
@RestController
@RequestMapping("/api/business/distribution")
public class DistributionController {

    @Autowired
    DistributionService distributionService;

    @ApiOperation("查询我的分销记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "客户编号", name = "businessNo", required = true, type = "string"),
            @ApiImplicitParam(value = "开始时间", name = "startDate", required = true, type = "string"),
            @ApiImplicitParam(value = "结束时间", name = "endDate", required = true, type = "string"),
            @ApiImplicitParam(value = "页码", name = "offset", required = true, type = "int"),
            @ApiImplicitParam(value = "显示行数", name = "limit", required = true, type = "int")
    })
    @GetMapping("")
    public JsonResult listDistribution(String businessNo, String startDate, String endDate, int offset, int limit) {
        return JsonResult.success(distributionService.listDistribution(businessNo, startDate, endDate, offset, limit));
    }
}
