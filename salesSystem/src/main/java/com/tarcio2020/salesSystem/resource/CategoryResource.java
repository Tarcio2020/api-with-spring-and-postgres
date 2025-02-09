package com.tarcio2020.salesSystem.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarcio2020.salesSystem.entities.Category;
import com.tarcio2020.salesSystem.services.CategoryService;

@Controller
@RequestMapping(value = "/categorys")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Category> create (@RequestBody Category category){
		Category obj = categoryService.create(category);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> obj = categoryService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
		Optional<Category> obj = categoryService.findById(id);
		return ResponseEntity.ok().body(obj);		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		categoryService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
