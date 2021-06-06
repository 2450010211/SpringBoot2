package com.lhf.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: lhf
 * @Date: 2021/6/3 22:27
 * 自定义监控端点
 */
@Component
@Endpoint(id = "myserver")
public class MyServerEndPoint {

    @ReadOperation
    public Map getReaderInfo() {
        return Collections.singletonMap("myserver", "server started....");
    }

    @WriteOperation
    public Map getWriteInfo() {
        return Collections.singletonMap("myserver", "server stopped....");
    }
}
