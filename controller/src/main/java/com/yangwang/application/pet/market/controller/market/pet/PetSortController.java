package com.yangwang.application.pet.market.controller.market.pet;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.PetSortService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 宠物一级分类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className PetSortController
 * @date 2020/3/22 11:52
 **/
@RestController
@RequestMapping("/api/market/sort")
@Api(description = "宠物一级分类")
public class PetSortController {

    @Resource
    PetSortService petSortService;

    @GetMapping("/list")
    @ApiOperation(value = "查询列表")
    public JsonResult listByParam(@Param("queryParam") String queryParam) {
        PagingQueryParam pagingQueryParam = PagingQueryParam.toObject(queryParam);
        if (pagingQueryParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        return JsonResult.success(petSortService.listByParam(pagingQueryParam));
    }


}
