package com.yangwang.application.pet.market.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @TODO
 * @Description
 * @Author Administrator
 * @Date 2019-07-03 0:07
 * @Version 1.0
 */
public class CustomerSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
