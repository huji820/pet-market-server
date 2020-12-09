package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.ItemTypeService;
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
 * 商品类别
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemTypeController
 * @date 2020/3/22 10:55
 **/
@RestController
@RequestMapping("api/item/type")
@Api(description = "商品类别")
public class ItemTypeController {
    @Resource
    ItemTypeService itemTypeService;

    @GetMapping("/list")
    @ApiOperation("获取商品类别列表")
    public JsonResult listByParam(@RequestParam("queryParam") String queryParam) {
        PagingQueryParam pagingQueryParam = PagingQueryParam.toObject(queryParam);
        if (pagingQueryParam == null) {
            return JsonResult.success(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        return JsonResult.success(itemTypeService.listByParam(pagingQueryParam));
    }
}
