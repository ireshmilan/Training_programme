package com.iresh.training.salesmanager.repository;

import java.util.List;

import com.iresh.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}