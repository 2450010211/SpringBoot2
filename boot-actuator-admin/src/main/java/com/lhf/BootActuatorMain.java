package com.lhf;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: lhf
 * @Date: 2021/6/5 22:50
 */
@SpringBootApplication
@EnableAdminServer
public class BootActuatorMain {

    public static void main(String[] args) {
        SpringApplication.run(BootActuatorMain.class, args);
    }
}
