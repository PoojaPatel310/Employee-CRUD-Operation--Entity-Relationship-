package com.aurosoft.employee.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="image",nullable = true)
	private String image;
	
	@Column(name="fname",nullable = false)
	private String fname;
	
	@Column(name="lname",nullable = false)
	private String lname;
	
	@Column(name="gender",nullable = false)
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="dob",nullable = false)
	private Date dob;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id", referencedColumnName = "id", nullable = false)
	private Department department;
	
	@Column(name="salary",nullable = false)
	private float salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getImage() {
		return image;
	}

	

	public void setImage(String image) {
		this.image = image;
	}

	public String getFname() {
		return (fname!=null)?fname.toUpperCase():"";
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		
		return (lname!=null)?lname.toUpperCase():"";
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public Employee(int id, String image, String fname, String lname, String gender, Date dob, Department department,
			float salary) {
		super();
		this.id = id;
		this.image = image;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	
	@Transient
	public String getPhotosImagePath() {
		  if (image == null | id == 0 ) return null;
	        
	        return "/employee-photos/" +id + "/" + image;
		
	}
	

	
	
	
	
}
