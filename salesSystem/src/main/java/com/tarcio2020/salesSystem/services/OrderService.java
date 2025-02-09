package com.tarcio2020.salesSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarcio2020.salesSystem.entities.Order;
import com.tarcio2020.salesSystem.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}
	
	public Order create(Order order) {
		return orderRepository.save(order);
	}
	
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}
}
