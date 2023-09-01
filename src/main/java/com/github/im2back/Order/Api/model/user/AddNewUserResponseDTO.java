package com.github.im2back.Order.Api.model.user;

public record AddNewUserResponseDTO(
		Long id,
		String name,
		String email,
		String phone
		
		
		) {
	

	public AddNewUserResponseDTO(User user) {
				this(user.getId(),user.getName(),user.getEmail(),user.getPhone());
				
	}
	
	
	
	

}
