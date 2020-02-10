package com.iresh.employeedemo.controller;

import com.iresh.employeedemo.model.Address;
import com.iresh.employeedemo.model.Employee;
import com.iresh.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("services")

public class EmployeeControler {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
   public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping("test")
    public Employee test() {
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("Iresh");

        Address adress = new Address();
        adress.setCity("Ruwanwella");
        adress.setCountry("SL");
        employee.setAddress(adress);
        return employee;
    }


}
