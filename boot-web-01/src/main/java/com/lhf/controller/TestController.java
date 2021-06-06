package com.lhf.controller;

import com.lhf.bean.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lhf
 * @Date: 2021/2/21 23:51
 */
@RestController
public class TestController {

    /**
     * 自动封装页面提交的参数
     * @return
     */
    @PostMapping("/saveuser")
    public Person getPerson(Person person){
        return person;
    }

    @GetMapping("user")
    public String getUser(){
        return "GET";
    }

    @PostMapping("user")
    public String saveUser(){
        return "POST";
    }

    @PutMapping("user")
    public String putUser(){
        return "PUT";
    }

    @DeleteMapping("user")
    public String deleteUser(){
        return "DELETE";
    }
}
