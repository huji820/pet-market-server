package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryPetGenreListParam;
import com.yangwang.application.pet.market.service.facade.common.PetGenreService;
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
 * 宠物二级分类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetGenreController
 * @date 2020/3/22 14:01
 **/
@RestController
@RequestMapping("/api/pet/genre")
@Api(description = "宠物二级分类")
public class PetGenreController {
    @Resource
    PetGenreService petGenreService;

    @GetMapping("/list")
    @ApiOperation(value = "查询宠物二级分类")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryPetGenreListParam queryPetGenreListParam = QueryPetGenreListParam.toObject(queryParam);
        if (queryPetGenreListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(petGenreService.listByParam(queryPetGenreListParam));
    }
}
