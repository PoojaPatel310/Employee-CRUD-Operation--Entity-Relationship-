package com.aurosoft.employee.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.aurosoft.employee.FileUploadUtil;
import com.aurosoft.employee.entity.Department;
import com.aurosoft.employee.entity.Employee;
import com.aurosoft.employee.service.DepartmentService;
import com.aurosoft.employee.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
		super();
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}

	@GetMapping("/list")
	public String listEmployee(Model m) {
	 List<Employee> list = employeeService.listAllEmployee();
		m.addAttribute("list",list);
		return "/Employee/list";
	}
	
	@GetMapping("/new")
	public String showForm(Employee employee ,Model m) {
		List<Department> list= departmentService.listAllDepartment();
		m.addAttribute("listdepartment",list);
		
		return "/Employee/add";
	}
	
	
	@PostMapping("/insert")
	public String insert( Employee employee,@RequestParam("image1") MultipartFile multipartFile) 
			throws IOException  {
        
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if(fileName.length() >3)
        {
        employee.setImage(fileName);         
        Employee savedEmployee = employeeService.insertEmployee(employee); 
        String uploadDir = "employee-photos/" + savedEmployee.getId(); 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        else
        {
        	employee.setImage("noming.png");
        	Employee savEmployee = employeeService.insertEmployee(employee);
        }
         
        return "redirect:/employee/list";
    }
		       
	
    
  
	
	@GetMapping(value="/edit/{id}")
		public String edit(@PathVariable int id,Model m) {
			Employee employee = employeeService.getEmployeeById(id);
			m.addAttribute("employee",employee);
			List<Department> list= departmentService.listAllDepartment();
			m.addAttribute("listdepartment",list);
			return"/Employee/edit";
		}
	
	@PostMapping(value="/update")
	 public String update( Employee employee,@RequestParam("image1") MultipartFile multipartFile) 
				throws IOException  {
	        
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        if(fileName.length() >3)
	        {
	        employee.setImage(fileName);         
	        Employee savedEmployee = employeeService.insertEmployee(employee); 
	        String uploadDir = "employee-photos/" + savedEmployee.getId(); 
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	        }
	        else
	        {
	        	Employee savEmployee = employeeService.insertEmployee(employee);
	        }
	         
	        return "redirect:/employee/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable int id ,Model m) {
		employeeService.deleteEmployee(id);
		return "redirect:/employee/list";
	}
	

}
