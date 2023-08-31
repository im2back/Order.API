package com.github.im2back.Order.Api.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.order.AddOrderItemDTO;
import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.model.order.OrderItem;
import com.github.im2back.Order.Api.model.product.Product;
import com.github.im2back.Order.Api.repositories.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository repository;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	
	
	public void insertNewOrderItems(List<AddOrderItemDTO> dados) {
		
		Set<OrderItem> newCart = new HashSet<>();
		for(AddOrderItemDTO element : dados) {
			Order order =  orderService.findById(element.idOrder());
		 		Product product =  productService.findByIdTwo(element.idProduct());
		 			OrderItem newOrderItem = new OrderItem(order, product, element.quantity(), product.getPrice());
		 				newCart.add(newOrderItem);
					}
	
		for(OrderItem items: newCart) {
			repository.save(items);
		}
	
	
	}
	

	
	
	
	
	
	
	
	
	
	
}
	
