package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetAppraiseListParam;
import com.yangwang.application.pet.market.service.facade.customer.PetAppraiseListService;
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
 * 宠物评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetAppraiseListController
 * @date 2020/3/23 18:05
 **/
@RestController
@Api(description = "宠物评价列表")
@RequestMapping("/api/pet/appraise/list")
public class PetAppraiseListController {
    @Resource
    PetAppraiseListService petAppraiseListService;

    @GetMapping
    @ApiOperation(value = "获取宠物评价列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryPetAppraiseListParam queryPetAppraiseListParam = QueryPetAppraiseListParam.toObject(queryParam);
        if (queryPetAppraiseListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(petAppraiseListService.list(queryPetAppraiseListParam));
    }
}
