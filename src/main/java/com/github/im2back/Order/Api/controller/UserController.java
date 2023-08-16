package com.github.im2back.Order.Api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.Order.Api.model.user.User;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@GetMapping
	ResponseEntity<User> findAll() {
		User user = new User(1L, "teste", "teste", "teste", "teste");
		return ResponseEntity.ok().body(user);
	}

}
