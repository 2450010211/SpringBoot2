package com.lhf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.bean.Employee;

import java.util.List;

/**
 * @Author: lhf
 * @Date: 2021/5/30 18:11
 */
public interface EmployeeService extends IService<Employee> {

    public List<Employee> getEmployeeList();

    public void saveEmp(Employee employee);
}
