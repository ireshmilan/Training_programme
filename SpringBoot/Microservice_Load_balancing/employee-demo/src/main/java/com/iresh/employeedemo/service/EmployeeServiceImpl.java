package com.iresh.employeedemo.service;

import com.iresh.employeedemo.hystrix.AllocationCommand;
import com.iresh.employeedemo.model.Allocation;
import com.iresh.employeedemo.model.Employee;
import com.iresh.employeedemo.model.Telephone;
import com.iresh.employeedemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Value("${service.host}")
    private String allocationServiceHost;

    @Value("${service.allocation.findAll}")
    private String findAll;

    @Value("${service.allocation.findByEmployeeId}")
    private String findByEmployeeIdURI;


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

    public Employee findById(Integer employeeId) {
        Optional<Employee> employees = employeeRepository.findById(employeeId);
        if (employees.isPresent())
            return employees.get();
        return new Employee();


    }

    public Employee fetchAllocation(Integer id) {

        Employee employee = this.findById(id);

        AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);

        employee.setAllocations(Arrays.asList(allocationCommand.execute()));

        return employee;
    }
}
