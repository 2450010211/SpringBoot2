package com.lhf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lhf
 * @Date: 2020/12/26 17:03
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello == springBoot2 to devTools";
    }
}
