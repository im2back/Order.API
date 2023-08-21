package com.github.im2back.Order.Api.model.user;

public record DadosDetalhamentoUsuario(
		String name,
		String email,
		String phone,
		String password
		) {
	

	public DadosDetalhamentoUsuario(User user) {
				this(user.getName(),user.getEmail(),user.getPhone(),user.getPassword());
				
	}
	
	

}
