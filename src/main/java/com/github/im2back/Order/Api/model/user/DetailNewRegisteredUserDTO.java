package com.github.im2back.Order.Api.model.user;

public record DetailNewRegisteredUserDTO(
		Long id,
		String name,
		String email,
		String phone
		
		
		) {
	

	public DetailNewRegisteredUserDTO(User user) {
				this(user.getId(),user.getName(),user.getEmail(),user.getPhone());
				
	}
	
	
	
	

}
