package com.github.im2back.Order.Api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.im2back.Order.Api.model.order.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>  {

}
