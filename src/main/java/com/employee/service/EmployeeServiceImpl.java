package com.employee.service;

import java.util.List;
import java.util.Optional;

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
		return employeeRepository.findAll();
	}
	
	/**@Parameter employeeId is the id of the employee to get the details
	 * @Return returns an Employee with the given id 
	 */
	@Override
	public Employee getEmployee(long employeeId) {
		return (employeeRepository.findById(employeeId)).orElse(null);
	}

	/**@Parameter Employee is the new employee to be created
	 * @Return returns the details of the created employee 
	 */
	@Override
	public Employee createEmployee(Employee employee) {
	return employeeRepository.save(employee);
	}

	/**@Parameter employeeId is the id of the employee to be deleted
	 * 
	 */
	@Override
	public void deleteEmployee(long id ) {
		 employeeRepository.deleteById(id);
	}

	/**@Parameter employeeId is the id of the employee to be updated
	 * @Return returns an Employee with the given id 
	 */
	@Override
	public Employee updateEmployee(long employeeId, Employee employee) {
		Optional<Employee> empToBeUpdated =   employeeRepository.findById(employeeId);
		
		if(empToBeUpdated.isPresent()) {
			empToBeUpdated.get().setEmployeeName(employee.getEmployeeName());
			empToBeUpdated.get().setCity(employee.getCity());
			return  employeeRepository.save(empToBeUpdated.get());			 		 
		}
		return null;
			
	}

}
