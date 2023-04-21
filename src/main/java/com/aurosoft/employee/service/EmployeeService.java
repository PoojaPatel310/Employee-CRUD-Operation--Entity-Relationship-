package com.aurosoft.employee.service;

import java.util.List;

import com.aurosoft.employee.entity.Employee;

public interface EmployeeService {
	
	
	List <Employee> listAllEmployee();
	Employee getEmployeeById(int id);
	Employee insertEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	int deleteEmployee(int id);
	

}
