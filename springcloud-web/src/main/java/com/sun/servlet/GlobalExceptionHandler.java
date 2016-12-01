package com.sun.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 集中异常处理
     *
     * @param request
     * @param response
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler
    @ResponseBody
    public String handlerException(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws Exception {
        log.error("GlobalExceptionHandler 捕获异常 并将错误返回前台 ", e);
        throw e;
    }

}
