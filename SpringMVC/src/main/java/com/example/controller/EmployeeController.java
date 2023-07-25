package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping("/employees")
	public String showEmployees(Model model) {
		List <Employee> employeeList = getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		return "employees";
		
	}
	
	private List<Employee> getEmployeeList(){
		List<Employee> employees = new ArrayList();
		
		employees.add(new Employee(1,"John Doe",30));
		employees.add(new Employee(2,"John Doe1",31));
		employees.add(new Employee(3,"John Doe2",32));
		return employees;
		
	}
	
	
	
	
	

}
