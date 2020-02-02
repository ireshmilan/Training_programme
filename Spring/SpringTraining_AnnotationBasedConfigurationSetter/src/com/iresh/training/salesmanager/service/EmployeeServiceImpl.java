package com.iresh.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iresh.training.salesmanager.model.Employee;
import com.iresh.training.salesmanager.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	// EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();

	
	EmployeeRepository employeeRepository;
	
//	public EmployeeServiceImpl() {
//System.out.println("Default Constructer Executed");
//	}
//
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
//
//	public EmployeeRepository getEmployeeRepository() {
//		return employeeRepository;
//	}
	
	
@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
	System.out.println("Setter injection fired");
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
