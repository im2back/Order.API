package com.github.im2back.Order.Api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.product.Product;
import com.github.im2back.Order.Api.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> user = repository.findById(id);
		Product product = user.get();
		return product;
	}
}
