package com.lhf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: lhf
 * @Date: 2021/5/30 18:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date buildTime;

}
