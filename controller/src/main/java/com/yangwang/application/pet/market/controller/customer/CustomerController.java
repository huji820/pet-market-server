package com.yangwang.application.pet.market.controller.customer;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.common.LoginInfo;
import com.yangwang.sysframework.utils.JsonResult;
import com.yangwang.sysframework.wechat.boot.WxUserInfoUtils;
import com.yangwang.sysframework.wechat.boot.model.WxUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 用户登录
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className LoginController
 * @date 2019/10/24 17:34
 **/
@RestController
@RequestMapping("/user")
@Api(description = "用户信息")
public class CustomerController {
    @Resource
    WxUserInfoUtils wxUserInfoUtils;

    @PostMapping("")
    @ApiOperation(value = "获取用户信息")
    public JsonResult login(@RequestBody LoginInfo loginInfo) throws Exception {
        if (loginInfo.getIv() == null || loginInfo.getCode() == null || loginInfo.getEncryptedData() == null) {
            return JsonResult.err(RespondCodeEnum.IS_NULL_DATA.getCode(), "登录数据为空");
        }

        // 获取登录信息
        WxUserInfo wxUserInfo = wxUserInfoUtils.getUserOpenId(loginInfo.getCode());

        // 解密数据
        wxUserInfo = wxUserInfoUtils.decryptUserInfo(loginInfo.getEncryptedData(), wxUserInfo.getSessionKey(), loginInfo.getIv());

        return JsonResult.success(wxUserInfo);
    }
}
