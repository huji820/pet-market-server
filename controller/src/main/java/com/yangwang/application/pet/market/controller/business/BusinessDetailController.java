package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.BusinessStateEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商家明细
 * </p>
 *
 * @author LiuXiangLin
 * @date 11:04 2020/3/18
 **/
@Api(description = "商家信息")
@RestController
@RequestMapping("/api/business/detail")
public class BusinessDetailController {
    @Resource
    BusinessService businessService;

    @GetMapping("/{businessNo:\\S+}")
    @ApiOperation(value = "获取商家信息")
    public JsonResult get(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(businessService.getByBusinessNoWithOutState(businessNo));
    }

    @PostMapping()
    @ApiOperation(value = "更新商家信息")
    public JsonResult update(@RequestBody Business business) {
        business.setComplete(1);
        business.setState(BusinessStateEnum.NORMAL.getType());
        return JsonResult.success(businessService.update(business));
    }
}
