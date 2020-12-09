package com.yangwang.application.pet.market.common.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @ClassName RegexUtils
 * @Description 正则验证工具类
 * @Author LiuXiangLin
 * @Date 2019/8/30 9:15
 * @Version 1.0
 **/
@Component
public class RegexUtils {
    /**
     * 电话号码长度
     */
    private static final int PHONE_LENGTH = 11;

    /**
     * 电话号码正则
     */
    private static final String PHONE_REGEX = "^[1][3-8][0-9]{9}$";

    /**
     * 身份证正则验证
     */
    private static final String ID_CARD_REGEX = "\\d{15}(\\d{2}[0-9xX])?";

    /**
     * 匹配整数或者小数
     **/
    private static final String NUMBER_REGEX = "[0-9]+.?[0-9]+";

    /**
     * 手机号码正则
     *
     * @param phone 电话号码
     * @return boolean
     * @author LiuXiangLin
     * @date 9:35 2019/11/5
     **/
    public static boolean isPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        if (phone.length() != PHONE_LENGTH) {
            return false;
        }
        return Pattern.matches(PHONE_REGEX, phone);
    }

    /**
     * <p>
     * 是否是正确的身份证号码
     * </p>
     *
     * @param idCardNumber 身份证号码
     * @return boolean
     * @author LiuXiangLin
     * @date 13:54 2020/3/12
     **/
    public static boolean isIdCardNumber(String idCardNumber) {
        return Pattern.matches(ID_CARD_REGEX, idCardNumber);
    }

    public static boolean isNumber(String numberStr) {
        return Pattern.matches(NUMBER_REGEX, numberStr);
    }
}
