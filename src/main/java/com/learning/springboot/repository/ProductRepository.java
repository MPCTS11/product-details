package com.learning.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.models.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
