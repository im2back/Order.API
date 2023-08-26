package com.github.im2back.Order.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.im2back.Order.Api.model.user.CadastroUserDTO;
import com.github.im2back.Order.Api.model.user.DadosAtualizacaoUsuario;
import com.github.im2back.Order.Api.model.user.DadosDetalhamentoUsuario;
import com.github.im2back.Order.Api.model.user.User;
import com.github.im2back.Order.Api.services.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	ResponseEntity <List<DadosDetalhamentoUsuario>> findAll() {
		List<User> user = service.findAll();
		List<DadosDetalhamentoUsuario> detailed = service.detailedUser(user);
		return ResponseEntity.ok().body(detailed);
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	ResponseEntity findById(@PathVariable Long id) {
		User user = service.findById(id);
		DadosDetalhamentoUsuario detailed = new DadosDetalhamentoUsuario(user);
		return ResponseEntity.ok().body(detailed);
	}
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	ResponseEntity insertUser(@RequestBody CadastroUserDTO cadastroUserDTO, UriComponentsBuilder uriBuilder) {
		
		User user = service.insertUser(cadastroUserDTO);
		
		var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(user));
	}
	
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Transactional
	ResponseEntity<DadosDetalhamentoUsuario> updateUser(@PathVariable Long id, @RequestBody DadosAtualizacaoUsuario dados) {
		var retorno = service.updateUser(id, dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(retorno));
	}
}
