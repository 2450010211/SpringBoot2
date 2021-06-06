package com.lhf.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: lhf
 * @Date: 2021/6/6 16:18
 */
@ConfigurationProperties("lhf.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
