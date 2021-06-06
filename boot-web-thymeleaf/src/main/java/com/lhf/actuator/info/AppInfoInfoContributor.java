package com.lhf.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author: lhf
 * @Date: 2021/6/3 21:42
 * 自定义服务info返回信息
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("msg", "Hello")
                .withDetails(Collections.singletonMap("word", "666"));

    }
}
