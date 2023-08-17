package com.github.im2back.Order.Api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.im2back.Order.Api.model.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long>  {

}
