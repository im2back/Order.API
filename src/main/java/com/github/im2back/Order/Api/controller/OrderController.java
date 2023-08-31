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
import com.github.im2back.Order.Api.model.order.OrderDTO;
import com.github.im2back.Order.Api.services.OrderService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
		
	
	@GetMapping(value = "/{userid}")
	ResponseEntity <List<OrderDTO>> findAllOrders(@PathVariable Long userid) {
		
	    var response = service.findAllOrders(userid);
			
		return ResponseEntity.ok().body(response);
	}
	
	
	@GetMapping(value = "/{idOrder}/user/{idUser}")
	ResponseEntity<OrderDTO> findByIdOrder(@PathVariable Long idOrder,@PathVariable Long idUser) {
	
			Order getOrder = service.findByIdOrder(idOrder, idUser);
				var responseOrder = new OrderDTO(getOrder);
			
					if (getOrder != null) {
						return ResponseEntity.ok().body(responseOrder);
							} else {
								return ResponseEntity.notFound().build();
									}
										}
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	ResponseEntity saveNewOrder(@RequestBody Order order, UriComponentsBuilder uriBuilder){
			
			var orderSave = service.insertNewOrder(order);
			var orderResponse = new OrderDTO(orderSave);
				
			var uri = uriBuilder.path("/orders/{id}").buildAndExpand(orderSave.getId()).toUri();
			
			return ResponseEntity.created(uri).body(orderResponse);
			
		
	}

}
