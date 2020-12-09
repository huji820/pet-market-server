package com.yangwang.application.pet.market.controller.common;

import com.yangwang.application.pet.market.common.enums.RespondCodeEnum;
import com.yangwang.application.pet.market.common.utils.RegexUtils;
import com.yangwang.application.pet.market.common.utils.StringUtils;
import com.yangwang.application.pet.market.model.vo.SmsVO;
import com.yangwang.application.pet.market.service.facade.common.VerificationCodeService;
import com.yangwang.application.pet.market.service.spring.common.VerificationCodeServiceImpl;
import com.yangwang.sysframework.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 验证码
 *
 * @author LiuXiangLin
 * @date 17:08 2019/10/30
 **/
@RestController
@RequestMapping("/business/VerificationCode")
public class VerificationCodeController {
    @Resource
    VerificationCodeService verificationCodeService;

    /**
     * 验证码ATTRIBUTE
     */
    public static final String SESSION_VERIFICATION_CODE_ATTRIBUTE = "verificationCode";

    @GetMapping("")
    public JsonResult getVerificationCode(@RequestParam("phoneNumber") String phone, HttpServletRequest httpServletRequest) throws Exception {
        // 电话号码判断
        if (!RegexUtils.isPhone(phone)) {
            return JsonResult.err(RespondCodeEnum.CHECK_ERROR.getCode(), "电话号码为空");
        }

        // 发送的验证码
        String code = verificationCodeService.sendVerificationCode(phone);

        if (StringUtils.isBlank(code)) {
            return JsonResult.err(RespondCodeEnum.UNKNOWN_ERROR.getCode(), "短信发送失败！");
        }

        SmsVO smsVO = new SmsVO(phone,code);

        // 将验证码对象放入session中（在没有使用redis的情况下这是最方便的方法）
        httpServletRequest.getSession().setAttribute(SESSION_VERIFICATION_CODE_ATTRIBUTE, smsVO);

        // 记录本次请求的时间
        VerificationCodeServiceImpl.VERIFICATION_CODE_MAP.put(phone, new Date());

        return JsonResult.success(code);
    }
}
