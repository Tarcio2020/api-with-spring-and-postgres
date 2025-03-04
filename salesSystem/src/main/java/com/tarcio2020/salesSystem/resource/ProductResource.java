package com.tarcio2020.salesSystem.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarcio2020.salesSystem.entities.Product;
import com.tarcio2020.salesSystem.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Product> create(Product product){
		Product obj = productService.create(product);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productService.findAllUsers();
		return ResponseEntity.ok().body(list);		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		productService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

