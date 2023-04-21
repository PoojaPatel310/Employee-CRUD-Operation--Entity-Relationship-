package com.aurosoft.employee.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="departments")
public class Department {

	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@OneToMany( mappedBy = "department", fetch = FetchType.LAZY)
	private Set <Employee> employeelist = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(Set<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public Department(int id, String name, Set<Employee> employeelist) {
		super();
		this.id = id;
		this.name = name;
		this.employeelist = employeelist;
	}

	public Department() {
		super();
	}

	

	

}
