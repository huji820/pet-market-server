package com.yangwang.application.pet.market.controller.market.common;

import com.yangwang.application.pet.market.service.facade.common.QueryFacedService;
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
 * 搜索
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className QueryController
 * @date 2020/3/25 10:47
 **/
@RestController
@RequestMapping("/api/query")
@Api(description = "搜索")
public class QueryController {
    @Resource
    QueryFacedService queryFacedService;

    @GetMapping("/{keyWord:\\S+}")
    @ApiOperation(value = "发起搜索")
    public JsonResult query(@PathVariable("keyWord") String keyWord) {
        return JsonResult.success(queryFacedService.query(keyWord));
    }
}
