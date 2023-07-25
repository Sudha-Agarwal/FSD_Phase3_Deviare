package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees = new ArrayList<>();

	@GetMapping
	public List<Employee> getAllEmployees(){
		employees.add(new Employee(1,"John Doe",30));
		employees.add(new Employee(2,"John Doe1",31));
		employees.add(new Employee(3,"John Doe2",32));
		return employees;		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employees.stream().filter(employee-> employee.getId().equals(id)).findFirst().orElse(null);		
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(4);
		employees.add(employee);
		return employee;
		
	}
	
	
}
