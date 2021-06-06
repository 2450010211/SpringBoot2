package com.lhf.service;

import com.lhf.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: lhf
 * @Date: 2021/6/6 16:17
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName) {
        return helloProperties.getPrefix() + ":" + userName + ":" + helloProperties.getSuffix();
    }
}
