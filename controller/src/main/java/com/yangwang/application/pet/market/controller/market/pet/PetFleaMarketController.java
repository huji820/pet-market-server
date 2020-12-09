package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.FleaMarketService;
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
 * 宠物跳蚤市场
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetFleaMarketController
 * @date 2020/3/14 14:38
 **/
@RestController
@RequestMapping("/api/market/flea-market")
@Api(description = "跳蚤市场")
public class PetFleaMarketController {
    @Resource
    FleaMarketService fleaMarketService;


    @GetMapping
    @ApiOperation(value = "查询列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        // 参数校验
        QueryPetMarketListParam queryPetMarketListParam = QueryPetMarketListParam.toObject(queryParam);
        if (queryPetMarketListParam == null) {
            return JsonResult.err(RespondCodeEnum.PARAM_ERROR.getCode(), "参数为空");
        }

        return JsonResult.success(fleaMarketService.list(queryPetMarketListParam));
    }
}
