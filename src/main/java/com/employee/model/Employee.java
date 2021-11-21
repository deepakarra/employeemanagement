package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long employeeid;

@NotEmpty(message = "Employee name cannot be null")
private String employeeName;

@NotEmpty(message = "city  cannot be null")
private String city;

public long getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}




}
