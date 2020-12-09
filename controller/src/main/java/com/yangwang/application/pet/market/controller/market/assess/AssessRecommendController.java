package com.yangwang.application.pet.market.controller.market.assess;

import com.yangwang.application.pet.market.service.facade.assess.AssessService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评测的controll
 * @Description
 * @Author huji
 * @Date 2020-05-15 2:49
 * @Version 1.0
 */
@Api(description = "评测")
@RestController
@RequestMapping("/api/assess/recommend")
public class AssessRecommendController {

    @Autowired
    AssessService assessService;

    @ApiOperation(value = "推荐的评测列表")
    @GetMapping("list")
    public JsonResult list() {
        return JsonResult.success(assessService.listReCommend());
    }

}
