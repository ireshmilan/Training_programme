package com.iresh.controler;

import com.iresh.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("services")
@XmlRootElement
public class EmployeeControler {

    @RequestMapping("/employees")
    public String display(){
        return ("hello");
//    public List<Employee> getEmployees() {
//        return Employee.getAllEmployees();
    }

}
