package com.tarcio2020.salesSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tarcio2020.salesSystem.entities.User;
import com.tarcio2020.salesSystem.repository.UserRepository;
import com.tarcio2020.salesSystem.services.exceptions.DatabaseException;
import com.tarcio2020.salesSystem.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void deleteById(Long id) {
		try {
		userRepository.deleteById(id);		
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User create (User user) {
		return userRepository.save(user);
	}

	public User update(Long id, User user) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, user);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

	}

}
