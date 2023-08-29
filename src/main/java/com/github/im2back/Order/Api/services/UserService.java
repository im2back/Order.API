package com.github.im2back.Order.Api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.infra.teste.exception.DataBaseException;
import com.github.im2back.Order.Api.infra.teste.exception.ResourceNotFoundException;
import com.github.im2back.Order.Api.model.user.UserRegistrationDTO;
import com.github.im2back.Order.Api.model.user.UpdateUserDTO;
import com.github.im2back.Order.Api.model.user.DetailUserDTO;
import com.github.im2back.Order.Api.model.user.User;
import com.github.im2back.Order.Api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Page<DetailUserDTO> findAll(Pageable paginacao) {
		return repository.findAll(paginacao).map(DetailUserDTO::new);
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insertNewUser(UserRegistrationDTO user) {
		User newUser = new User(user);

		return repository.save(newUser);

	}

	public void deleteUser(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(id);
		}
	}

	public User updateUser(Long id, UpdateUserDTO dados) {

		try {
			var entity = repository.findById(id);
			User user = entity.get();
			user.updateUser(dados);
			return user;
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}

	}
	
	public List<DetailUserDTO> detailedUser(List<User> user) {
		List<DetailUserDTO> list = new ArrayList<>();
		for (User x : user) {
			new DetailUserDTO(x);
			list.add(new DetailUserDTO(x));
		}
	  return	list;
		
	}

}
