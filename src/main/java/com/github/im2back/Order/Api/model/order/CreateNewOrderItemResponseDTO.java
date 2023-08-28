package com.github.im2back.Order.Api.model.order;

import java.util.Set;

public record CreateNewOrderItemResponseDTO(
		Set<OrderItem> orderItem,
		Double total
		
		) {
	
	public CreateNewOrderItemResponseDTO(Order order) {
		this(order.getItems(),order.getTotal());
    }

}
