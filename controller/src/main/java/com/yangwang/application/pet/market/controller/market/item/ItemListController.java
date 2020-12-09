package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryItemListParam;
import com.yangwang.application.pet.market.model.vo.ItemVo;
import com.yangwang.application.pet.market.service.facade.common.ItemListService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemListController
 * @date 2020/3/22 9:54
 **/
@RestController
@RequestMapping("/api/item/list")
@Api(description = "商品列表")
public class ItemListController {
    @Resource
    ItemListService itemListService;

    @GetMapping
    @ApiOperation("获取商品列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryItemListParam queryItemListParam = QueryItemListParam.toObject(queryParam);
        if (queryItemListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");
        }
        queryItemListParam.dealWithParam();
        return JsonResult.success(itemListService.list(queryItemListParam));
    }

    @GetMapping("/listManufactorItem")
    @ApiOperation("获取厂家商品")
    public JsonResult listManufactorItem(@RequestParam("businessNo")String businessNo){
        List<ItemVo> itemVos = itemListService.listManufactorItem(businessNo);
        return JsonResult.success(itemVos);
    }
}
