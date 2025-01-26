package com.tarcio2020.salesSystem.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarcio2020.salesSystem.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Tarcio", "tarcio#hotmail.com", "999999999", "123456");
		return ResponseEntity.ok().body(user);
	}
}
