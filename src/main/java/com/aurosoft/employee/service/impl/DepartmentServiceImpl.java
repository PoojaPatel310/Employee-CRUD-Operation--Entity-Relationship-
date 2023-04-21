package com.aurosoft.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.employee.entity.Department;
import com.aurosoft.employee.repository.DepartmentRepository;
import com.aurosoft.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentRepository repository;

	@Override
	public List<Department> listAllDepartment() {
		
		return repository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public void insertDepartment(Department department) {
		repository.save(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		repository.save(department);
	}

	@Override
	public int deleteDepartment(int id) {
		 repository.deleteById(id);
		 return id;
	}

}
