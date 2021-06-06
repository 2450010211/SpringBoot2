package com.lhf.service.impl;

import com.lhf.bean.User;
import com.lhf.mapper.UserMapper;
import com.lhf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lhf
 * @Date: 2021/5/30 15:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.userById(id);
    }
}
