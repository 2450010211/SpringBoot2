package com.lhf;

import com.lhf.bean.Pet;
import com.lhf.bean.User;
import com.lhf.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @Author: lhf
 * @Date: 2020/12/26 17:00
 */
@SpringBootApplication
public class HelloWorldMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloWorldMain.class, args);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("-----------------------------------------------");
        //从容器中获取的都是单例
//        Pet pet1 = applicationContext.getBean("petTomcat", Pet.class);
//        Pet pet2 = applicationContext.getBean("petTomcat", Pet.class);
//        System.out.println(pet1 == pet2);
        System.out.println("-----------------------------------------------");

//        Config bean = applicationContext.getBean(Config.class);
//        System.out.println(bean);
//
//        System.out.println("从配置类中获取到的对象是否相等:" + (bean.user() == bean.user()));
//        System.out.println("从配置类中获取到的对象和从容器中获取到的是否相等:" + (pet1 == bean.pet()));

        System.out.println("-----------------------------------------------");

        String[] beanNamesForType = applicationContext.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        System.out.println("-----------------------------------------------");

        boolean user = applicationContext.containsBean("user");
        System.out.println(user);
        boolean petTomcat = applicationContext.containsBean("pet");
        System.out.println(petTomcat);

        System.out.println("-----------------------------------------------");
        boolean haha = applicationContext.containsBean("haha");
        System.out.println(haha);
    }
}
