package com.yangwang.application.pet.market.common.utils;


import java.util.UUID;

/**
 * @ClassName StringUtils
 * @Description String工具类
 * @Author LSY
 * @Date 2019/10/18
 * @Version 1.0
 **/
public class StringUtils {
    /**
     * 获取UUID
     *
     * @param
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 18:45 2019/10/23
     **/
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 字符串是否是空或者空白的
     *
     * @param str 需要判断的字符串
     * @return boolean
     * @author LiuXiangLin
     * @date 10:13 2019/10/26
     **/
    public static boolean isBlank(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        // 遍历字符串
        for (int i = 0; i < str.length(); ++i) {
            // 只要有一个不是空白符就返回false
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
