package com.yangwang.application.pet.market.config;

import com.yangwang.sysframework.utils.EnumResultCode;
import com.yangwang.sysframework.utils.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * description //TODO
 * Date 16:24 2019/9/6
 * Param
 * return
 **/

@ControllerAdvice
public class DefaultExceptionHandler {
    /**
     * 全局异常捕捉处理
     *
     * @param e
     * @return JsonResult
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult defaultExceptionHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return JsonResult.err(EnumResultCode.UNKNOW_EXCEPTION.getCode(), e.getMessage());
    }
}
