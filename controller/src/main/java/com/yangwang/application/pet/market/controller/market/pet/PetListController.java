package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.PetListService;
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
 * 宠物类列表（不区分跳蚤市场、高端宠物、团购宠物）
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetListController
 * @date 2020/4/27 17:00
 **/
@RestController()
@RequestMapping("/api/market/pet/list")
@Api(description = "宠物列表")
public class PetListController {
    @Resource
    PetListService petListService;

    @GetMapping
    @ApiOperation(value = "通过多个参数查询宠物列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryPetMarketListParam queryPetMarketListParam = QueryPetMarketListParam.toObject(queryParam);
        queryPetMarketListParam.dealWithParam();
        return JsonResult.success(petListService.listMarketPet(queryPetMarketListParam));
    }
}
