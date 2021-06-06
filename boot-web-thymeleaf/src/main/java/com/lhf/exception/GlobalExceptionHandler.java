package com.lhf.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: lhf
 * @Date: 2021/5/29 12:53
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handlerArithmeticException(Exception e){
        log.info("异常:{}", e);
        return "login"; //视图地址
    }
}
