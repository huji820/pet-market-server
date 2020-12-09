package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.ItemPackService;
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
 * 套餐列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemPackController
 * @date 2020/3/22 10:18
 **/
@RestController
@Api(description = "套餐列表")
@RequestMapping("/api/item/pack")
public class ItemPackController {
    @Resource
    ItemPackService itemPackService;

    @GetMapping("/list")
    @ApiOperation(value = "获取所有的套餐")
    public JsonResult listAll(@RequestParam("queryParam") String queryParam) {
        PagingQueryParam pagingQueryParam = PagingQueryParam.toObject(queryParam);
        if (pagingQueryParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        return JsonResult.success(itemPackService.listAll(pagingQueryParam));
    }
}
