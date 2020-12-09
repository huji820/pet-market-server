package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.PagingQueryParam;
import com.yangwang.application.pet.market.service.facade.common.ItemBrandService;
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
 * 商品品牌
 * </p>
 *
 * @author LiuXiangLin
 * @date 10:35 2020/3/22
 **/
@Api(description = "商品品牌")
@RestController
@RequestMapping("/api/item/brand")
public class ItemBrandController {
    @Resource
    ItemBrandService itemBrandService;

    @GetMapping("/list")
    @ApiOperation(value = "获取品牌列表")
    public JsonResult listItemBrand(@RequestParam("queryParam") String queryParam) {
        PagingQueryParam pagingQueryParam = PagingQueryParam.toObject(queryParam);
        if (pagingQueryParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误");
        }
        return JsonResult.success(itemBrandService.listByParam(pagingQueryParam));
    }
}
