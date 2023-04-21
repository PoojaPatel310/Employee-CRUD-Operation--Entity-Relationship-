package com.aurosoft.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.employee.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Integer>{

}
