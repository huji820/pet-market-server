package com.yangwang.application.pet.market.controller.common;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.model.business.Business;
import com.yangwang.application.pet.market.model.common.Customer;
import com.yangwang.application.pet.market.model.common.LoginInfo;
import com.yangwang.application.pet.market.service.facade.business.LoginService;
import com.yangwang.application.pet.market.service.service.BusinessService;
import com.yangwang.sysframework.utils.JsonResult;
import com.yangwang.sysframework.utils.StringUtil;
import com.yangwang.sysframework.wechat.boot.WxUserInfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:11 2020/3/16
 **/
@RestController
@RequestMapping("/login")
@Api(description = "登录")
public class LoginController {

    @Resource
    WxUserInfoUtils wxUserInfoUtils;

    @Resource
    LoginService loginService;

    @Resource
    BusinessService businessService;

    @PostMapping()
    @ApiOperation(value = "登录")
    public JsonResult decode(@RequestBody LoginInfo loginInfo, HttpSession session) {
        Customer customer = loginService.weApp(loginInfo, wxUserInfoUtils.decryptUserInfo(loginInfo.getEncryptedData(), loginInfo.getWxUserInfo().getSessionKey(), loginInfo.getIv()).getPurePhoneNumber());

        if (customer != null) {
            customer.setOpenid(loginInfo.getWxUserInfo().getOpenid());
            session.setAttribute("customer", customer);
        }

        return customer == null ? JsonResult.err(RespondCodeEnum.IS_NULL_DATA.getCode(), "登录失败！") : JsonResult.success(customer);
    }

}
