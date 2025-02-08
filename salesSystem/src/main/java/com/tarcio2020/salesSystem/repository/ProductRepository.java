package com.tarcio2020.salesSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarcio2020.salesSystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
