package com.aurosoft.employee.service;

import java.util.List;

import com.aurosoft.employee.entity.Department;

public interface DepartmentService {
	

	List <Department> listAllDepartment();
	Department getDepartmentById(int id);
	void insertDepartment(Department department);
	void updateDepartment(Department department);
	int deleteDepartment(int id);

}
