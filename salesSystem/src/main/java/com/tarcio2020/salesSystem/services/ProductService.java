package com.tarcio2020.salesSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarcio2020.salesSystem.entities.Product;
import com.tarcio2020.salesSystem.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAllUsers(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);		
	}
	
	public Product create (Product product) {
		return productRepository.save(product);
	}
	
}
