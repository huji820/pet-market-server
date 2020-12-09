package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.params.QueryPetMarketListParam;
import com.yangwang.application.pet.market.service.facade.common.ItemGrouponListService;
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
 * 商品团购列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemGrouponListController
 * @date 2020/5/26 10:20
 **/
@RestController
@Api(description = "商品团购列表")
@RequestMapping("/api/item/groupon/list")
public class ItemGrouponListController {
    @Resource
    ItemGrouponListService itemGrouponListService;

    @GetMapping
    @ApiOperation(value = "获取团购列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryItemListParam queryItemListParam = QueryItemListParam.toObject(queryParam);
        if (queryItemListParam == null) {
            return JsonResult.err(RespondCodeEnum.PARAM_ERROR.getCode(), "请求参数有误！");
        }
        queryItemListParam.dealWithParam();
        return JsonResult.success(itemGrouponListService.listByParam(queryItemListParam));
    }
}
