package com.lhf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.bean.Employee;
import com.lhf.mapper.EmployeeMapper;
import com.lhf.service.EmployeeService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: lhf
 * @Date: 2021/5/30 18:13
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    Counter counter;

    /**
     * 使用metrics监控端点 监控该saveEmp方法调用的次数
     * @param meterRegistry
     */
    public EmployeeServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("employeeService.saveEmp.count");
    }

    @Override
    public List<Employee> getEmployeeList() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        return employees;
    }

    @Override
    public void saveEmp(Employee employee) {
        counter.increment();
        employee.setBuildTime(new Date());
        employeeMapper.insertEmp(employee);
    }
}
