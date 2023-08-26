package com.github.im2back.Order.Api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.order.OrderItem;
import com.github.im2back.Order.Api.repositories.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository repository;
	
	public OrderItem insert(OrderItem orderItem) {
		
		return repository.save(orderItem);
	}
	
	
	
	
}
