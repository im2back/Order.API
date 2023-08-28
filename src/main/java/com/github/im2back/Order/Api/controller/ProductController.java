package com.github.im2back.Order.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.product.Product;
import com.github.im2back.Order.Api.services.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	ResponseEntity findAll() {
		List<Product> user = service.findAll();
		return ResponseEntity.ok().body(user);
		
	}
	
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Product> findById(@PathVariable Long id) {
		Product user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
