package com.github.im2back.Order.Api.model.user;

public record AddNewUserRequestDTO(
		String name,
		String email,
		String phone,
		String password
		) {


}
