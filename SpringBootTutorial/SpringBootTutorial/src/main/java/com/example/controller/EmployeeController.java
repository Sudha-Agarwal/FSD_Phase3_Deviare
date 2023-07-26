package com.example.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private Set<Employee> employees = new HashSet<>();

	@GetMapping
	public Set<Employee> getAllEmployees(){
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employees.removeIf(employee -> employee.getId().equals(id));
		return new ResponseEntity<>("employee record deleted",HttpStatus.ACCEPTED);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee){
		Employee employee = employees.stream()
				.filter(e -> e.getId().equals(id))
				.findFirst()
				.orElse(null);
		
		if(employee != null) {
			employee.setName(updatedEmployee.getName());
			employee.setAge(updatedEmployee.getAge());
		}
		
		return new ResponseEntity<>("employee record updated",HttpStatus.OK);	
		
				
	}
	
	
	
	
}
