package com.github.im2back.Order.Api.model.user;

import java.util.List;
import java.util.stream.Collectors;

import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.model.order.OrderDTO;



public record DetailUserDTO(
		Long id,
		String name,
		String email,
		String phone,
		
		List<OrderDTO> order 
		
		) {
	

	public DetailUserDTO(User user) {
	
	 this(user.getId(),user.getName(),user.getEmail(),user.getPhone(),conversion(user.getOrder()));
	    

		
				
	}
	
	public static List<OrderDTO> conversion(List<Order> order) {
		
		List<OrderDTO> orderDTOList = order.stream()
	            .map(order1 -> new OrderDTO(order1)) 
	            .collect(Collectors.toList());
		return orderDTOList;
	}

	
	
	
	

}
