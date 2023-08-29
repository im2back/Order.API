package com.github.im2back.Order.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.order.AddOrderItemDTO;
import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.model.order.OrderItem;
import com.github.im2back.Order.Api.model.order.CreateNewOrderItemResponseDTO;
import com.github.im2back.Order.Api.model.product.Product;
import com.github.im2back.Order.Api.services.OrderItemService;
import com.github.im2back.Order.Api.services.OrderService;
import com.github.im2back.Order.Api.services.ProductService;

@RestController
@RequestMapping(value = "items")
public class OrderItemController {
	
	@Autowired
	private OrderItemService service;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	@PostMapping
	@SuppressWarnings("rawtypes")
	ResponseEntity createShoppingCart(@RequestBody AddOrderItemDTO dados) {
		
		 Order order =  orderService.findById(dados.idOrder());
		 Product product =  productService.findByIdTwo(dados.idProduct());
		 
		 OrderItem newOrderItem = new OrderItem(order, product, dados.quantity(), product.getPrice());
		
		 service.insert(newOrderItem);
		 
		 CreateNewOrderItemResponseDTO resposta = new CreateNewOrderItemResponseDTO(newOrderItem.getOrder().getItems(),
				 newOrderItem.getOrder().getTotal());
		 return ResponseEntity.created(null).body(resposta);
	 }
	

	
	

	
	
	
	
	
	
	
}