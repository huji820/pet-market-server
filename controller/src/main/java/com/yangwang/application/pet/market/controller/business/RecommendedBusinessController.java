package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.service.facade.common.RecommendedBusinessService;
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
 * 推荐商家
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className RecommendedBusinessController
 * @date 2020/3/17 11:19
 **/
@RestController
@RequestMapping("/api/business/recommended")
@Api(description = "推荐商家")
public class RecommendedBusinessController {
    @Resource
    RecommendedBusinessService recommendedBusinessService;

    @GetMapping
    @ApiOperation(value = "推荐商家列表")
    public JsonResult get(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
        return JsonResult.success(recommendedBusinessService.list(offset, limit));
    }
}
