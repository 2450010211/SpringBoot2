package com.lhf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: lhf
 * @Date: 2021/5/30 18:08
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    public Integer insertEmp(Employee employee);

}
