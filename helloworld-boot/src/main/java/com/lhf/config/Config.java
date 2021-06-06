package com.lhf.config;

import com.lhf.bean.Pet;
import com.lhf.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: lhf
 * @Date: 2021/1/1 20:12
 * 该配置类也会注册到容器中
 *  proxyBeanMethods: 代理bean的方法，注册的bean如果没有依赖关系，proxyBeanMethods建议设置成false,提升启动速度
 *      Full:(proxyBeanMethods = true)  Config中注册的bean是单例的，注册的内容bean也会管理起来。由CGLIB进行代理
 *      Lite:(proxyBeanMethods = false) Config注册的内容bean不会管理
 */
@Import({User.class})   //把当前类交由容器管理,容器的名字是全类名
@Configuration(proxyBeanMethods = true)
//@ConditionalOnBean(name = "pet") //条件装配，包含某个容器才创建这个bean
@ConditionalOnMissingBean(name = "pet")
@ImportResource("classpath:bean.xml")   //引入其他xml配置文件交由容器管理
public class Config {

    @Bean
    public User user(){
        return new User("嘟嘟",18);
    }

    @Bean
    public Pet pet(){
        return new Pet("tomcat");
    }
}
