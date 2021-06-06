package com.lhf.controller;

import com.lhf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lhf
 * @Date: 2021/6/6 16:32
 */
@RestController
public class HelloStarterController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String helloStarter() {
        return helloService.sayHello("HelloStarter");
    }

}
