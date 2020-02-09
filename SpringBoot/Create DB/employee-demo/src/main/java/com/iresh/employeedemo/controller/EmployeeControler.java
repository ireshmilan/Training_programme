package com.iresh.employeedemo.controller;

import com.iresh.employeedemo.model.Employee;
import com.iresh.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("services")

public class EmployeeControler {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
   public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

}
