package com.github.im2back.Order.Api.model.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.im2back.Order.Api.model.product.Product;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name= "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPk id= new OrderItemPk();
	
	@Getter @Setter
	private Integer quantity;
	@Getter @Setter
	private Double price;
	
	public OrderItem(Order order, Product product,Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		this.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Order product) {
		this.setOrder(product);
	}
	
	
}
