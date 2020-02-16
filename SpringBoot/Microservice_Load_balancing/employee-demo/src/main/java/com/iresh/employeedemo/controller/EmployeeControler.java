package com.iresh.employeedemo.controller;

import com.iresh.employeedemo.model.Address;
import com.iresh.employeedemo.model.Allocation;
import com.iresh.employeedemo.model.Employee;
import com.iresh.employeedemo.model.Telephone;
import com.iresh.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/services")

public class EmployeeControler {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
   public Employee save(@RequestBody Employee employee){

        return employeeService.save(employee);
    }

    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employee/allocation/{id}")
    public Employee getFetchAllocation(@PathVariable Integer id) {

        return employeeService.fetchAllocation(id);
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

        Telephone telephone = new Telephone();
        telephone.setNumber("0772402832");
        telephone.setEmployee(employee);
        List<Telephone> list = new ArrayList<>();
	    list.add(telephone);

        return employee;
    }


}
