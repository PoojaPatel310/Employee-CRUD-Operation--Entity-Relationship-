package com.aurosoft.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
