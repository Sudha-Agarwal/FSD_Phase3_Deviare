package com.example.Phase3_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Phase3_Project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
