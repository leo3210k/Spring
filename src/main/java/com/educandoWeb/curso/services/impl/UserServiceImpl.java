package com.educandoWeb.curso.services.impl;

import java.util.List;
import java.util.Optional;

import com.educandoWeb.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.repositories.UserRepository;

// Poderia ser @Component, que também registra a classe como um componente do Spring,
// podendo ser injetado automaticamente com o @Autowired, mas o @Service é utilizado
// para ficar mais semanticamente específico
@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
