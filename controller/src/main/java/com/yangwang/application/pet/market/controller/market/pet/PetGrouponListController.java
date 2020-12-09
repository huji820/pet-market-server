package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.PetGrouponListService;
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
 * 团购列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGrouponListController
 * @date 2020/3/25 15:54
 **/
@RestController
@RequestMapping("/api/pet/groupon/list")
@Api(description = "团购列表")
public class PetGrouponListController {
    @Resource
    PetGrouponListService petGrouponListService;

    @GetMapping
    @ApiOperation(value = "获取团购列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryPetMarketListParam queryPetMarketListParam = QueryPetMarketListParam.toObject(queryParam);
        if (queryPetMarketListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数为空");
        }
        queryPetMarketListParam.dealWithParam();
        return JsonResult.success(petGrouponListService.listByParam(queryPetMarketListParam));
    }
}
