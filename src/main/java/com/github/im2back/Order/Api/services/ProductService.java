package com.github.im2back.Order.Api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.product.DetailProductDTO;
import com.github.im2back.Order.Api.model.product.Product;
import com.github.im2back.Order.Api.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Page<DetailProductDTO> findAll(Pageable paginacao){
		return  repository.findAll(paginacao).map(DetailProductDTO::new);
		
				
	}
	
	public DetailProductDTO findById(Long id) {
		Optional<Product> product = repository.findById(id);
		
		DetailProductDTO productReturn = new DetailProductDTO(product.get());
		
		return productReturn;
	}
	
	public Product findByIdTwo(Long id) {
		Optional<Product> product = repository.findById(id);
		Product productReturn = product.get();
		return productReturn;
	}
}
