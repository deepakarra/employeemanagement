package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


/*
 * Controller class to redirect the requests of the employeemanagement based on the end points
 */

@RestController
@RequestMapping("/employees")
class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public String getEmployees() {
		return "retreiving all employees";
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee newEmployee=employeeService.createEmployee(employee);
		return new ResponseEntity(newEmployee,HttpStatus.CREATED);
	}

	@DeleteMapping
	public String deleteEmployee() {
		return "delete employee";
	}
	
	@PutMapping
	public String updateEmployee() {
		return "udating employee";
	}
}
