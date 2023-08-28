package com.github.im2back.Order.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.services.OrderService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	ResponseEntity<List<Order>> findAll() {
		List<Order> user = service.findAll();
		return ResponseEntity.ok().body(user);
	}
	
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Order> findById(@PathVariable Long id) {
		Order user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	ResponseEntity insertOrder(@RequestBody Order order, UriComponentsBuilder uriBuilder){
		
		
			Order order1 = new Order(null, order.getMoment(), order.getOrderStatus(), order.getClient());
				service.insert(order1);
			
			var uri = uriBuilder.path("/orders/{id}").buildAndExpand(order1.getId()).toUri();
			
			return ResponseEntity.created(uri).body(order1);
			
		
	}

}
