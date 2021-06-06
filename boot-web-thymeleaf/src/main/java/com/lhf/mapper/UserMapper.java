package com.lhf.mapper;

import com.lhf.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lhf
 * @Date: 2021/5/30 15:40
 */
@Mapper
public interface UserMapper {

    public User userById(@Param("id") Long id);

}
