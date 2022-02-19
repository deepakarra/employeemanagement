package com.employee.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employee.model.Employee;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	@Autowired
	protected MockMvc mvc;
	
	@Before
	public void setupTestdata() throws Exception {
		String uri = "/employees";
		String requestBody = "{\r\n" + "\"employeeName\":\"emp1\",\r\n" + "\"city\":\"Ams\"\r\n" + "}";
		mvc.perform(MockMvcRequestBuilders.post(uri).
				contentType(MediaType.APPLICATION_JSON).
				content(requestBody));
	}
	
	@Test
	@Order(1)
	public void createsEmployeeSuccessfully() throws Exception {
		String uri = "/employees";
		Employee emp = new Employee();
		emp.setEmployeeName("emp1");
		emp.setCity("Ams");
		String requestBody = "{\r\n" + "\"employeeName\":\"emp1\",\r\n" + "\"city\":\"Ams\"\r\n" + "}";
				mvc.perform(MockMvcRequestBuilders.post(uri).
						contentType(MediaType.APPLICATION_JSON).
						content(requestBody))
						.andExpect(status().isCreated())
						.andExpect(content().json("{'employeeid':4, 'employeeName':'emp1','city':'Ams'}"))
						.andReturn();		
	}

	@Test
	@Order(2)
	public void returnsEmployeesSuccessfully() throws Exception {
		String uri = "/employees";
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("[{'employeeid':1, 'employeeName':'emp1','city':'Ams'}]"))
				.andReturn();
		
	}
	
	@Test
	@Order(3)
	public void getEmployeeByIdSuccessfully() throws Exception {
		String uri = "/employees/1" ;
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("{'employeeid':1, 'employeeName':'newEmp','city':'Ams'}"))
				.andReturn();
		
	}
	
	@Test
	@Order(4)
	public void updatesEmployeeDetailsSuccessfully() throws Exception {
		String updateuri = "/employees/1" ;
		String newRequestBody = "{\r\n" + "\"employeeName\":\"newEmp\",\r\n" + "\"city\":\"Ams\"\r\n" + "}";
		mvc.perform(MockMvcRequestBuilders.put(updateuri).contentType(MediaType.APPLICATION_JSON)
		        .content(newRequestBody))
			.andExpect(status().is2xxSuccessful())
	         	.andExpect(content().json("{'employeeid':1, 'employeeName':'newEmp','city':'Ams'}"))
				.andReturn();
		
	}
}