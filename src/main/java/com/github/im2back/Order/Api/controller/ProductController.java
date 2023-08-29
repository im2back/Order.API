package com.github.im2back.Order.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.product.DetailProductDTO;
import com.github.im2back.Order.Api.services.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	ResponseEntity <Page<DetailProductDTO>> findAllProducts(@PageableDefault (size = 10, sort = {"id"}) Pageable paginacao, 
			@RequestParam(name = "page", defaultValue = "0")int pageNumber) {
		
			Page<DetailProductDTO> productList = service.findAll(paginacao);
		
			return ResponseEntity.ok().body(productList);
		
	}
	
	
	@GetMapping(value = "/{id}")
	ResponseEntity<DetailProductDTO> findByIdProduct(@PathVariable Long id) {
		
		DetailProductDTO product = service.findById(id);
		
		return ResponseEntity.ok().body(product);
	}

}
