package com.lhf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: lhf
 * @Date: 2021/5/29 15:35
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "自定义异常ResponseStatus")
public class ResponseStatusException extends RuntimeException{

    public ResponseStatusException(){
    }

    public ResponseStatusException(String message){
        super(message);
    }
}
