package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	//returns all employees
	@Override
	public List<Employee> getAllEmployees() {
		
		return null;
	}

	@Override
	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}

	@Override
	public Employee deleteEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
