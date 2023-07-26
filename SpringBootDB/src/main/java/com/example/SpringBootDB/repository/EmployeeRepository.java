package com.example.SpringBootDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootDB.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
