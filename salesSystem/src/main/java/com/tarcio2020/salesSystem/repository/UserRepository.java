package com.tarcio2020.salesSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarcio2020.salesSystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
