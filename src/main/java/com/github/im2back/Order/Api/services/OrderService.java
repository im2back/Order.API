package com.github.im2back.Order.Api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.order.Order;
import com.github.im2back.Order.Api.model.order.OrderDTO;
import com.github.im2back.Order.Api.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private UserService userService;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> user = repository.findById(id);
		return user.get();
	}

	public Order insertNewOrder(Order order) {
		Order orderSave = new Order(null, order.getMoment(), order.getOrderStatus(), order.getClient());
			repository.save(orderSave);
				return orderSave;
	}

	public Order findByIdOrder(Long idOrder, Long idUser) {

		var user = userService.findById(idUser);
		var order = user.getOrder();

		Order getOrder = null;
		for (Order x : order) {
			if (x.getId().equals(idOrder)) {
				getOrder = x;
				break;
			}
		}
		return getOrder;
	}

	public List<OrderDTO> findAllOrders(Long id) {
		var user = userService.findById(id);
		var order = user.getOrder();
		
			List<OrderDTO> response = new ArrayList<>();
				for(Order x : order) {
					var newOrderDTO = new OrderDTO(x);
						response.add(newOrderDTO);
				                     }
		return response;
	}
}
