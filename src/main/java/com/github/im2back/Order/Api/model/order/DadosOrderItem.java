package com.github.im2back.Order.Api.model.order;

public record DadosOrderItem(
		Long idOrder,
		Long idProduct,
		Integer quantity
		
		) {

}
