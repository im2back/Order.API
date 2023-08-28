package com.github.im2back.Order.Api.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.im2back.Order.Api.model.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name= "tabela_user") 
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter	
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String phone;
	
	@Getter @Setter
	private String password;
	
	@JsonIgnore
	@Getter
	@OneToMany(mappedBy = "client")
	private List<Order> order = new ArrayList<>();

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public User(UserRegistrationDTO cadastroUserDTO) {
		super();
		this.name = cadastroUserDTO.name();
		this.email = cadastroUserDTO.email();
		this.phone = cadastroUserDTO.phone();
		this.password = cadastroUserDTO.password();
	}
	
	public void updateUser(UpdateUserDTO dados) {
	        if (dados.name() != null) {
	            this.name = dados.name();
	        }
	        if (dados.email() != null) {
	            this.email = dados.email();
	        }
	        if (dados.phone() != null) {
	            this.phone = dados.phone();
	        }

	    }

	
}
