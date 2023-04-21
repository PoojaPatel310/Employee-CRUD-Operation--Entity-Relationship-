package com.aurosoft.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.employee.entity.Employee;
import com.aurosoft.employee.repository.EmployeeRepository;
import com.aurosoft.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> listAllEmployee() {
		
		return repository.findAll();
	} 

	@Override
	public Employee getEmployeeById(int id) {
		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Employee insertEmployee(Employee employee) {
	 	return repository.save(employee);
		
	}

	

	@Override
	public int deleteEmployee(int id) {
		
	 repository.deleteById(id);
	 return id;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	
	

}
