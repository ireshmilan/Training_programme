package com.iresh.employeedemo.service;

import com.iresh.employeedemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getAllEmployees();

    Employee findById(Integer employeeId);
    Employee fetchAllocation(Integer id);

}
