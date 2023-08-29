package com.github.im2back.Order.Api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.im2back.Order.Api.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {
	
	Page<Product> findAll(Pageable paginacao);

}
