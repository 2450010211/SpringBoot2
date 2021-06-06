package com.lhf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhf.bean.Employee;
import com.lhf.bean.User;
import com.lhf.exception.ResponseStatusException;
import com.lhf.service.EmployeeService;
import com.lhf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lhf
 * @Date: 2021/3/21 16:15
 */
@Controller
public class TableController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmp")
    @ResponseBody
    public Employee saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return employee;
    }

    @ResponseBody
    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserById(id);
    }

    @ResponseBody
    @GetMapping(value = "/sql")
    public String query() {
        Long count = jdbcTemplate.queryForObject(" SELECT count(*) FROM `user` ", Long.class);
        return count.toString();
    }

    @GetMapping("/err")
    public String toPageErr(){
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping(value = "/rse")
    public String responseStatusException(){
        throw new ResponseStatusException();
    }

    @GetMapping("/basic_table")
    public String basicTablePage(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
//        List<Employee> employeeList = employeeService.getEmployeeList();
//        List<User> users = Arrays.asList(
//                new User("AA", "123456"),
//                new User("BB", "abc123"),
//                new User("CC", "def123"),
//                new User("DD", "ghi123")
//        );


        //分页
        Page<Employee> page = new Page<>(pn, 3);
        Page<Employee> employeePage = employeeService.page(page);
        List<Employee> records = employeePage.getRecords();

        model.addAttribute("employees", records);
        model.addAttribute("page", employeePage);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){
        return "table/editable_table";
    }
}
