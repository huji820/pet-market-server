package com.yangwang.application.pet.market.controller.market.item;

import com.yangwang.application.pet.market.service.facade.common.ItemDetailService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品明细
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemDetailController
 * @date 2020/4/29 11:28
 **/
@RestController
@Api(description = "商品明细")
@RequestMapping("/api/item/detail")
public class ItemDetailController {
    @Resource
    ItemDetailService itemDetailService;

    @GetMapping("/{itemNo:\\w+}")
    @ApiOperation(value = "通过主键获取商品详情")
    public JsonResult get(@PathVariable("itemNo") int itemNo) {
        return JsonResult.success(itemDetailService.get(itemNo));
    }
}
