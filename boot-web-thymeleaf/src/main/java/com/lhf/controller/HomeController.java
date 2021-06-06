package com.lhf.controller;

import com.lhf.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: lhf
 * @Date: 2021/3/21 15:26
 */
@Controller
@Slf4j
public class HomeController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        if(user == null){
            log.info("请输入用户名和密码");
            model.addAttribute("msg", "请输入用户名和密码");
            return "login";
        }else {
            if(user.getUserName() == null || user.getUserName().trim().length() < 0){
                log.info("请输入用户名");
                model.addAttribute("msg", "请输入用户名");
                return "login";
            }else if (!"zxc123".equals(user.getPassword())){
                log.info("请输入密码或者密码不正确");
                model.addAttribute("msg", "输入密码或者密码不正确");
                return "login";
            }
        }
        session.setAttribute("loginUser", user);
        //登录成功重定向main.html,为了解决重复提交的问题
        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String loginMain(Model model){

        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String mainCount = operations.get("/main.html");
        String sqlCount = operations.get("/sql");
        String dynamicTableCount = operations.get("/dynamic_table");

        model.addAttribute("main", mainCount);
        model.addAttribute("sql", sqlCount);
        model.addAttribute("dynamicTable", dynamicTableCount);
        return "index";
    }
}
