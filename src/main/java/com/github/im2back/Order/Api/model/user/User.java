package com.github.im2back.Order.Api.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name= "tb_user")
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
	
	@Getter
	@OneToMany(mappedBy = "client")
	private List<Order> order = new ArrayList<>();

}
