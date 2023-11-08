package com.example.springsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>  {
    
}
