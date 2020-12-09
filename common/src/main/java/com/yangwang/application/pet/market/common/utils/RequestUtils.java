package com.yangwang.application.pet.market.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户请求的工具类
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className RequestUtils
 * @date 2019/10/29 15:42
 **/
public class RequestUtils {
    /**
     * 获取用户ip地址
     *
     * @param request request请求对象
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 15:43 2019/10/29
     **/
    public static String getAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        try {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (NullPointerException e) {
            ip = "127.0.0.1";
        }
        return ip;
    }
}
