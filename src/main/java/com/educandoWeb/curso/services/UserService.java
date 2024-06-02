package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.repositories.UserRepository;

// Poderia ser @Component, que também registra a classe como um componente do Spring,
// podendo ser injetado automaticamente com o @Autowired, mas o @Service é utilizado
// para ficar mais semanticamente específico
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
