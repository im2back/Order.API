package com.github.im2back.Order.Api.model.order;

import java.time.Instant;
import java.util.Set;

public record OrderDTO(
		Long id,
		Instant moment,
		OrderStatus orderStatus,
		Set<OrderItem> items,
		Double total
		
		) {
	
	public OrderDTO(Order order) {
		this(order.getId(),order.getMoment(),order.getOrderStatus(),order.getItems(),getTotal(order.getItems()));
		
	}
	
	
	public static Double getTotal(Set<OrderItem> items) {
		Double total = 0.0;
	
		
		for (OrderItem item : items) {
			total += item.getSubTotal();
			
			}
		return total;
	}

}
