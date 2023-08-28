package com.github.im2back.Order.Api.model.user;

public record UserRegistrationDTO(
		String name,
		String email,
		String phone,
		String password
		) {


}
