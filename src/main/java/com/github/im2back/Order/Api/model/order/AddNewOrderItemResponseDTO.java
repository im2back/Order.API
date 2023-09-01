package com.github.im2back.Order.Api.model.order;

import java.util.Set;

public record AddNewOrderItemResponseDTO(
		Set<OrderItem> orderItem,
		Double total
		
		) {
	
	public AddNewOrderItemResponseDTO(Order order) {
		this(order.getItems(),order.getTotal());
    }

}
