package com.github.im2back.Order.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.order.DadosOrderItem;
import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.model.order.OrderItem;
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
	ResponseEntity createOI(@RequestBody DadosOrderItem dados) {
		
		 
		 
		Order order =  orderService.findById(dados.idOrder());
		
		System.out.println("teste2 ");
		
		Product product =  productService.findById(dados.idProduct());
		 
		System.out.println("teste3");
		 var oi = new OrderItem(order, product, dados.quantity(), product.getPrice());
		
		OrderItem savedOI = service.insert(oi);
		 
		 return ResponseEntity.created(null).body(savedOI);
	 }
	

  

}
