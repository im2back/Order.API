package com.github.im2back.Order.Api.model.order;

public record AddOrderItemDTO(
		Long idOrder,
		Long idProduct,
		Integer quantity
		
		) {

}
