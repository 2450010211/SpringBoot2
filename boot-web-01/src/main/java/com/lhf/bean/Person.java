package com.lhf.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lhf
 * @Date: 2021/2/28 0:43
 */
@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
