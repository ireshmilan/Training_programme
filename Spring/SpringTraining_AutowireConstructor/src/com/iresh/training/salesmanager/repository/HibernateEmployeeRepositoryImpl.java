package com.iresh.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import com.iresh.training.salesmanager.model.Employee;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setemployeeName("Iresh");
		employee.setemployeeLocation("Ruwanwella");
		employees.add(employee);
		return employees;
	}
}
