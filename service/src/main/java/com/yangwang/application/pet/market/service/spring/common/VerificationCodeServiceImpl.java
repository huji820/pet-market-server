package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.SMSTemplateTypeEnum;
import com.yangwang.application.pet.market.service.facade.common.VerificationCodeService;

import com.yangwang.sysframework.sms.SmsRequestBody;
import com.yangwang.sysframework.sms.SmsUtil;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName VerificationCodeServiceImpl
 * @Description
 * @Author LiuXiangLin
 * @Date 2019/8/30 9:30
 * @Version 1.0
 **/
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    /**
     * 短信验证码最近一次使用时间
     */
    public static final Map<String, Date> VERIFICATION_CODE_MAP = new ConcurrentHashMap<>();

    /***/
    private static final BigDecimal ONE_MIN_MILS = BigDecimal.valueOf(60000);

//    @Resource
//    SmsUtil smsUtil;

    @Override
    public String sendVerificationCode(String phone) throws Exception {
        /*// 获取上一次的发送时间
        Date date = VERIFICATION_CODE_MAP.getPrice(phone);

        if (differOnMin(date, new Date())) {
            // 获取一个随机数
            String code = String.valueOf(new Random().nextInt(899999) + 100000);
            // 创建数据
            List<RequestData> requestDataList = new ArrayList<>();
            requestDataList.add(new RequestData("code", code));
            // 发送短信
            SMSRespond smsRespond = smsUtils.sendSMS(new SMSRequestBody(phone, requestDataList, SMSTemplateTypeEnum.BUSINESS_VERIFICATION_CODE.getTemplateId()));
            if (smsRespond.getError_code().equals(String.valueOf(0))) {
                // 发送成功
                return code;
            }
        }
*/
//        String code = String.valueOf(new Random().nextInt(899999) + 100000);
//
//        SmsRequestBody srb = new SmsRequestBody();
//        srb.setPhone(phone);
//        srb.addTemplateData("code", code);
//        srb.setTemplateNo("SMS_182672504");
//        srb.setSignName("淘宠惠手机注册验证码");
//        boolean result = smsUtil.sendSms(srb);
//
//        if (result) {
//            return code;
//        }
        return null;
    }


    /**
     * @return boolean
     * @Author LiuXiangLin
     * @Description 是否相隔了一分钟
     * @Date 10:03 2019/8/30
     * @Param [beforDate, afterDate]
     **/
    private boolean differOnMin(Date beforeDate, Date afterDate) {
        if (beforeDate == null) {
            return true;
        }
        return TypeConvertUtil.$BigDecimal(afterDate.getTime()).subtract(TypeConvertUtil.$BigDecimal(beforeDate.getTime())).abs().compareTo(ONE_MIN_MILS) > 0;
    }
}
