package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<Employee>> getAllEmployes() {
		List<Employee> emp = employeeService.getAllEmployees();
	
			return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployes(@PathVariable long  id) {
		Employee emp = employeeService.getEmployee(id);
		if(null!=emp) {
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
			}
			return  new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid  @RequestBody Employee employee) {
	return new ResponseEntity<Employee>(employeeService.createEmployee(employee),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id); 
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable long  id, @RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		if(null!=updatedEmployee) {
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
		}
		return  new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
}
