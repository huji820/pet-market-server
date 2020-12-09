package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.CollectionUtils;
import com.yangwang.application.pet.market.model.market.PetOrderVo;
import com.yangwang.application.pet.market.service.facade.common.PetTransportService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 宠物运输
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetTransportController
 * @date 2020/3/26 9:29
 **/
@RestController
@Api(description = "宠物运输")
@RequestMapping("/api/pet/transport")
public class PetTransportController {
    @Resource
    PetTransportService transportService;

    @GetMapping("/type")
    @ApiOperation(value = "获取运输类型")
    public JsonResult getTransportType(@RequestParam("startCity") String startCity,
                                       @RequestParam("endCity") String endCity) {
        if (StringUtils.isBlank(startCity) || StringUtils.isBlank(endCity)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数缺失！");
        }
        // 获取所有的运输类型
        List<Integer> transportTypeList = transportService.listTransportType(startCity, endCity);

        return CollectionUtils.isNotEmpty(transportTypeList)
                ? JsonResult.success(transportTypeList)
                : JsonResult.err(RespondCodeEnum.QUERY_ERR.getCode(), "暂无该路线！");
    }

    @PostMapping("/price")
    @ApiOperation(value = "获取运输价格")
    public JsonResult getTransportPrice(@RequestBody PetOrderVo petOrderVo) {
        BigDecimal price = transportService.getTransportPrice(petOrderVo);
        return price == null || price.compareTo(BigDecimal.ZERO) == 0
                ? JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "暂无价格！")
                : JsonResult.success(price);
    }

    @GetMapping("/state/{orderNo:\\w+}")
    @ApiOperation(value = "获取运输订单")
    public JsonResult getTransportState(@PathVariable String orderNo) {
        return JsonResult.success(transportService.getOrderState(orderNo));
    }
}
