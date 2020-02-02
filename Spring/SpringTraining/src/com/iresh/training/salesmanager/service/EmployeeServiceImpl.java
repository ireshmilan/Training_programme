package com.iresh.training.salesmanager.service;

import java.util.List;

import com.iresh.training.salesmanager.model.Employee;
import com.iresh.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	// EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	private EmployeeRepository employeeRepository;

	//Default Constructor is must
	public EmployeeServiceImpl() {
		
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
