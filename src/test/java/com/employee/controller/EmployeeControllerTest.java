package com.employee.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.employee.model.Employee;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	
    @Autowired
	protected MockMvc mvc;
    
	@Test
	@Order(1)
	public void createsEmployeeSuccessfully()  throws Exception{
	String uri = "/employees"	;
	
	Employee emp = new Employee();
	emp.setEmployeeName("emp1");
	emp.setCity("Ams");
	String requestBody ="{\r\n"
			+ "\"employeeName\":\"testUser5\",\r\n"
			+ "\"city\":\"ams\"\r\n"
			+ "}";
	String responseBody ="{\r\n"
			+ "\"employeeid\":\"1\",\r\n"
			+ "\"employeeName\":\"testUser5\",\r\n"
			+ "\"city\":\"ams\"\r\n"
			+ "}";
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(requestBody)).andReturn();
	assertEquals(201,mvcResult.getResponse().getStatus());
}
    
	@Test
	@Order(2)
	public void returnsEmployeesSuccessfully()  throws Exception{
	String uri = "/employees"	;
	String responseBody ="{\r\n"
			+ "\"employeeName\":\"testUser5\",\r\n"
			+ "\"city\":\"ams\"\r\n"
			+ "}";
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
	assertEquals(200,mvcResult.getResponse().getStatus());
	
}
}