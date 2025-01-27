package com.tarcio2020.salesSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarcio2020.salesSystem.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
