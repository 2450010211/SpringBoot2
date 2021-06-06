package com.lhf.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lhf
 * @Date: 2021/6/3 21:11
 * 自定义健康检查
 * 访问路径：http://localhost:8080/actuator/health
 */
@Component
public class MyHealthHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(1 == 1) {
            builder.status(Status.UP);
            resultMap.put("status", 200);
            resultMap.put("ms", 100);
        }else {
            builder.status(Status.OUT_OF_SERVICE);
            resultMap.put("status", 500);
            resultMap.put("ms", 3000);
        }
        builder.withDetail("code", 200)
                .withDetails(resultMap);
    }
}
