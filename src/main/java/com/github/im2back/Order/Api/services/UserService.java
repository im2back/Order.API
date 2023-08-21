package com.github.im2back.Order.Api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.user.User;
import com.github.im2back.Order.Api.model.user.CadastroUserDTO;
import com.github.im2back.Order.Api.model.user.DadosAtualizacaoUsuario;
import com.github.im2back.Order.Api.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User insertUser(CadastroUserDTO user) {
		User newUser = new User(user);
		
		return repository.save(newUser);
		
	}

	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	public User updateUser(Long id, DadosAtualizacaoUsuario dados) {
		var entity = repository.findById(id);
		User user = entity.get();
		user.updateUser(dados);
		
		
		
		return user;
		
	}

}
