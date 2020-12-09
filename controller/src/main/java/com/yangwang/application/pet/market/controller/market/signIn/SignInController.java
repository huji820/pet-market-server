package com.yangwang.application.pet.market.controller.market.signIn;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.common.signIn.SignIn;
import com.yangwang.application.pet.market.service.facade.signIn.SignInService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 签到
 */
@RestController
@Api(description = "签到")
@RequestMapping("/api/signIn")
public class SignInController {

    @Resource
    SignInService signInService;

    @ApiOperation("签到")
    @PostMapping("")
    public JsonResult signIn(@RequestParam("businessNo")String businessNo){
        int i = signInService.signIn(businessNo);
        return i>0?JsonResult.success():JsonResult.err(RespondCodeEnum.UNKNOWN_ERROR.getCode(),"签到失败");
    }

    @ApiOperation("通过签到人获取本人的签到记录")
    @GetMapping("/getByBusinessNo")
    public JsonResult getByBusinessNo(@RequestParam("businessNo")String businessNo){
        SignIn sign = signInService.getByBusinessNo(businessNo);
        return JsonResult.success(sign);
    }

    @ApiOperation("查看用户是否签到 true已签到 false未签到")
    @GetMapping("/signInOrNot")
    public JsonResult signInOrNot(@RequestParam("business")String businessNo){
        boolean b = signInService.signInOrNot(businessNo);
        return JsonResult.success(b);
    }
}
