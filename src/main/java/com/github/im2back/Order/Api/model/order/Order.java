package com.github.im2back.Order.Api.model.order;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.im2back.Order.Api.model.payment.Payment;
import com.github.im2back.Order.Api.model.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Table(name = "tabela_order")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@Getter @Setter
	@OneToOne(mappedBy = "order", cascade =CascadeType.ALL)
	private Payment payment;

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	} 

	
	public Double getTotal() {
		Double total = 0.0;
	
		
		for (OrderItem item : items) {
			total += item.getSubTotal();
			
			}
		return total;
	}
	
	public Set<OrderItem> getItems(){
		return items;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 	
	
}
