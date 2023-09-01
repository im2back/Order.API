package com.github.im2back.Order.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.category.CategoryAllAttributesDTO;
import com.github.im2back.Order.Api.services.CategoryService;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	ResponseEntity<List<CategoryAllAttributesDTO>> findAll() {
		
		List<CategoryAllAttributesDTO> categoryResponse = service.findAll();
		
		return ResponseEntity.ok().body(categoryResponse);
	}
	
	
	@GetMapping(value = "/{id}")
	ResponseEntity<CategoryAllAttributesDTO> findById(@PathVariable Long id) {
		
		CategoryAllAttributesDTO categoryResponse = service.findById(id);
		
		return ResponseEntity.ok().body(categoryResponse);
	}
	
	

}
