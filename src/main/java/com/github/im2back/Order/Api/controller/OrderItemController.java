package com.github.im2back.Order.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.order.AddNewOrderItemRequestDTO;
import com.github.im2back.Order.Api.model.order.AddNewOrderItemResponseDTO;
import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.services.OrderItemService;
import com.github.im2back.Order.Api.services.OrderService;

@RestController
@RequestMapping(value = "items")
public class OrderItemController {
	
	@Autowired
	private OrderItemService service;
	@Autowired
	private OrderService orderService;

	
	@PostMapping
	
	ResponseEntity <AddNewOrderItemResponseDTO> saveNewOrderItem(@RequestBody List<AddNewOrderItemRequestDTO> dados) {
		
		service.insertNewOrderItems(dados);
		 
		 AddNewOrderItemRequestDTO getElement = dados.get(0); 
		 Order order =  orderService.findById(getElement.idOrder());
		 AddNewOrderItemResponseDTO responseList = new AddNewOrderItemResponseDTO(order);
		 
		 return ResponseEntity.created(null).body(responseList);
	 }
	


	
	
}