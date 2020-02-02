package com.iresh.training.salesmanager.service;

import java.util.List;

import com.iresh.training.salesmanager.model.Employee;
import com.iresh.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepository employeeRepository;

	// Default Constructor
	public EmployeeServiceImpl() {
		System.out.println("Default Construtor");
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overload Constructor execute");
		this.employeeRepository = employeeRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
