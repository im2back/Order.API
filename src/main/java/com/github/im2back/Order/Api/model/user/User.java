package com.github.im2back.Order.Api.model.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String password;

}
