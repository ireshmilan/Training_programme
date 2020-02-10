package com.iresh.employeedemo.service;

import com.iresh.employeedemo.model.Employee;
import com.iresh.employeedemo.model.Telephone;
import com.iresh.employeedemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        for (Telephone telephone:employee.getTelephones()) {
            telephone.setEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
