package com.github.im2back.Order.Api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.im2back.Order.Api.model.user.UserRegistrationDTO;
import com.github.im2back.Order.Api.model.user.UpdateUserDTO;
import com.github.im2back.Order.Api.model.user.DetailNewRegisteredUserDTO;
import com.github.im2back.Order.Api.model.user.DetailUserDTO;
import com.github.im2back.Order.Api.model.user.User;
import com.github.im2back.Order.Api.services.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	ResponseEntity <Page<DetailUserDTO>> findAllUsers(@PageableDefault(size = 10, sort = { "id"}) Pageable paginacao,
			@RequestParam(name = "page", defaultValue = "0")int pageNumber) {
		
	
		var userPage = service.findAll(paginacao);
		
		
		return ResponseEntity.ok(userPage);
	}
	
	
	@GetMapping(value = "/{id}")
	ResponseEntity<DetailUserDTO> findByIdUser(@PathVariable Long id) {
		User user = service.findById(id);
		DetailUserDTO detailed = new DetailUserDTO(user);
		return ResponseEntity.ok().body(detailed);
	}
	
	@PostMapping
	@Transactional
	ResponseEntity<DetailNewRegisteredUserDTO> insertNewUser(@RequestBody UserRegistrationDTO cadastroUserDTO, UriComponentsBuilder uriBuilder) {
		
		User user = service.insertNewUser(cadastroUserDTO);
		
		var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DetailNewRegisteredUserDTO(user));
	}
	
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Transactional
	ResponseEntity<DetailUserDTO> updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO dados) {
		User updateUserReturn = service.updateUser(id, dados);
		
		return ResponseEntity.ok(new DetailUserDTO(updateUserReturn));
	}
}
