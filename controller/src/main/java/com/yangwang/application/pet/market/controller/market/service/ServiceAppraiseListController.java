package com.yangwang.application.pet.market.controller.market.service;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryItemAppraiseListParam;
import com.yangwang.application.pet.market.model.service.QueryServiceAppraiseListParam;
import com.yangwang.application.pet.market.service.facade.customer.ItemAppraiseListService;
import com.yangwang.application.pet.market.service.facade.service.ServiceAppraiseListService;
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
 * 商品评价列表
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className ItemAppraiseListController
 * @date 2020/3/24 13:52
 **/
@RestController
@RequestMapping("/api/service/appraise/list")
@Api(description = "服务评价列表")
public class ServiceAppraiseListController {
    @Resource
    ServiceAppraiseListService serviceAppraiseListService;

    @GetMapping
    @ApiOperation(value = "获取评价列表")
    public JsonResult get(@RequestParam("queryParam") String queryParam) {
        QueryServiceAppraiseListParam queryServiceAppraiseListParam = QueryServiceAppraiseListParam.toObject(queryParam);
        if (queryServiceAppraiseListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数错误！");

        }
        return JsonResult.success(serviceAppraiseListService.list(queryServiceAppraiseListParam));
    }
}
