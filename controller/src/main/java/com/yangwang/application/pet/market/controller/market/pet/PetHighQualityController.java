package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.HighQualityService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 高端市场
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className HighQualityController
 * @date 2020/3/16 17:48
 **/
@RestController
@Api(description = "高端市场")
@RequestMapping("/api/market/high-quality")
public class PetHighQualityController {
    @Resource
    HighQualityService highQualityService;

    @GetMapping()
    @ApiOperation(value = "列表查询")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        // 参数校验
        QueryPetMarketListParam queryPetMarketListParam = QueryPetMarketListParam.toObject(queryParam);
        if (queryPetMarketListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数缺失！");
        }
        return JsonResult.success(highQualityService.list(queryPetMarketListParam));
    }
}
