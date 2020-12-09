package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetBusinessListParam;
import com.yangwang.application.pet.market.service.facade.common.PetListService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 宠物列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetListController
 * @date 2020/3/20 13:37
 **/
@RestController
@RequestMapping("/api/business/pet/list")
@Api(description = "商家宠物类列表")
public class PetBusinessListController {
    @Resource
    PetListService petListService;

    @GetMapping()
    @ApiOperation("获取列表")
    public JsonResult list(@RequestParam("queryParamStr") String queryParamStr) {
        QueryPetBusinessListParam queryPetBusinessListParam = QueryPetBusinessListParam.toObject(queryParamStr);
        if (queryPetBusinessListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数为空");
        }
        return JsonResult.success(petListService.listBusinessPet(queryPetBusinessListParam));
    }
}
