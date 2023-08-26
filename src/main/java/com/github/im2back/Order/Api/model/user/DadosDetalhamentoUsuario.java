package com.github.im2back.Order.Api.model.user;

import java.util.List;

import com.github.im2back.Order.Api.model.order.Order;

public record DadosDetalhamentoUsuario(
		Long id,
		String name,
		String email,
		String phone,
		List<Order> order
		
		) {
	

	public DadosDetalhamentoUsuario(User user) {
				this(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getOrder());
				
	}
	
	

}
