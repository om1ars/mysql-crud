package com.example.mysqlcrud.repository;

import com.example.mysqlcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
