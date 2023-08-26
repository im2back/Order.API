package com.github.im2back.Order.Api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> user = repository.findById(id);
		return user.get();
	}
	
	public Order insert(Order order) {
		
		repository.save(order);
		return order;
	}
}
