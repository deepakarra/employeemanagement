package com.employee.controller;

//import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

import com.employee.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	@Autowired
	protected MockMvc mvc;

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
						.andExpect(content().json("{'employeeid':2, 'employeeName':'emp1','city':'Ams'}"))
						.andReturn();		
	}

	@Test
	@Order(2)
	public void returnsEmployeesSuccessfully() throws Exception {
		String uri = "/employees";
		String requestBody = "{\r\n" + "\"employeeName\":\"emp1\",\r\n" + "\"city\":\"Ams\"\r\n" + "}";
		mvc.perform(MockMvcRequestBuilders.post(uri).
				contentType(MediaType.APPLICATION_JSON).
				content(requestBody));
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("[{'employeeid':1, 'employeeName':'emp1','city':'Ams'}]"))
				.andReturn();
		
	}
}