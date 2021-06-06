package com.lhf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: lhf
 * @Date: 2021/3/21 15:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String password;
    private Date buildTime;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

}
