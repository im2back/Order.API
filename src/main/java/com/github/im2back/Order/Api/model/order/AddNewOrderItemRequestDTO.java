package com.github.im2back.Order.Api.model.order;

public record AddNewOrderItemRequestDTO(
		Long idOrder,
		Long idProduct,
		Integer quantity
		
		) {

}
