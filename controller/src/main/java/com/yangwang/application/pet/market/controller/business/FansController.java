package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.params.QueryFansListParam;
import com.yangwang.application.pet.market.service.service.FansService;
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
 * 粉丝
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className FansController
 * @date 2020/3/25 9:44
 **/
@RestController
@RequestMapping("/api/fans")
@Api(description = "粉丝")
public class FansController {
    @Resource
    FansService fansService;

    @GetMapping
    @ApiOperation(value = "查询粉丝列表")
    public JsonResult list(@RequestParam("queryParam") String queryParam) {
        QueryFansListParam queryFansListParam = QueryFansListParam.toObject(queryParam);
        if (queryFansListParam == null) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "参数校验错误！");
        }
        queryFansListParam.dealWithParam();
        return JsonResult.success(fansService.listByParam(queryFansListParam));
    }
}
