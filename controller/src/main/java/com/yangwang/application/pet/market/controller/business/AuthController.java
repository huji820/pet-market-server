package com.yangwang.application.pet.market.controller.business;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.vo.AuthVo;
import com.yangwang.application.pet.market.service.service.AuthService;
import com.yangwang.application.pet.market.service.facade.common.AuthFacadeService;
import com.yangwang.sysframework.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 商家认证
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:05 2020/3/19
 **/
@Api(description = "商家认证管理")
@RestController
@RequestMapping("/api/business/auth")
public class AuthController {
    @Resource
    AuthFacadeService authFacadeService;

    @Resource
    AuthService authService;

    @ApiOperation(value = "通过商家编号查询认证")
    @GetMapping("/{businessNo:\\w+}")
    public JsonResult listByAuthNo(@PathVariable("businessNo") String businessNo) {
        return JsonResult.success(authService.getByBusinessNo(businessNo));
    }

    @ApiOperation(value = "上传商家认证")
        @PostMapping()
        public JsonResult saveAuth(@RequestBody AuthVo authVo) {
            return authFacadeService.save(authVo) > 0
                    ? JsonResult.success()
                    : JsonResult.err(RespondCodeEnum.INSERT_ERROR.getCode(), "上传失败！");
    }
}