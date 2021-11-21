package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee();
	
	public Employee createEmployee(Employee employee);
	
	public Employee deleteEmployee();
	
	public Employee updateEmployee();

}
