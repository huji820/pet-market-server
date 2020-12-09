package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.SMSTemplateTypeEnum;
import com.yangwang.application.pet.market.common.utils.AliSmsUtils;
import com.yangwang.application.pet.market.service.facade.common.SMSMessageReminderService;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: trunk
 * @description: 短信消息提醒
 * @author: lsy
 * @create: 2019-12-06 14:30
 **/
@Service
public class SMSMessageReminderServiceImpl implements SMSMessageReminderService {
    /**
     * 短信验证码最近一次使用时间
     */
    public static final Map<String, Date> VERIFICATION_CODE_MAP = new ConcurrentHashMap<>();

    private static final BigDecimal ONE_MIN_MILS = BigDecimal.valueOf(60000);
    @Resource
    AliSmsUtils aliSmsUtils;

    @Override
    public String sendDeliveryMessageReminder(String phone,String name,String waybill) throws Exception {
        /*// 获取上一次的发送时间
        Date date = VERIFICATION_CODE_MAP.getPrice(phone);

        if (differOnMin(date, new Date())) {
            List<RequestData> requestDataList = new ArrayList<>();

            requestDataList.add(new RequestData("name",name));
            requestDataList.add(new RequestData("waybill",waybill));

            SMSRespond smsRespond = smsUtils.sendSMS(new SMSRequestBody(phone,requestDataList, SMSTemplateTypeEnum.BUSINESS_VERIFICATION_CODE.getTemplateId()));

            if (smsRespond.getError_code().equals(String.valueOf(0))) {
                // 发送成功
                return name;
            }


        }

        return null;*/

//        SmsRequestBody srb = new SmsRequestBody();
//        srb.setPhone(phone);
//        srb.addTemplateData("name", name);
//        srb.addTemplateData("waybill", waybill);
//        srb.setTemplateNo("SMS_182672504");
//        srb.setSignName("淘宠惠手机注册验证码");
//        boolean result = smsUtil.sendSms(new SmsRequestBody());
//        if (result) {
//            return name;
//        }
        return null;
    }

    @Override
    public void sendMsgToBusiness(String phone) throws Exception{
        aliSmsUtils.sendSms(null, phone, SMSTemplateTypeEnum.SALES_STIPS_CODE.getTemplateId());
    }

    /**

     * @description 判断是否相隔一分钟
     * @return
     * @author lsy
     * @date 14:45 2019/12/6
     **/
    private boolean differOnMin(Date beforeDate, Date afterDate) {
        if (beforeDate == null) {
            return true;
        }
        return TypeConvertUtil.$BigDecimal(afterDate.getTime()).subtract(TypeConvertUtil.$BigDecimal(beforeDate.getTime())).abs().compareTo(ONE_MIN_MILS) > 0;
    }
}
