package com.educandoWeb.curso.resources.impl;

import java.util.List;

import com.educandoWeb.curso.resources.UserResource;
import com.educandoWeb.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.services.impl.UserServiceImpl;

// Usado para falar que nossa classe é um recurso Web que é
// implementado por um controlador Rest
@RestController
@RequestMapping(value = "/users")
public class UserResourceImpl implements UserResource {

	private UserService service;

	public UserResourceImpl(UserService service) {
		this.service = service;
	}

	// Método para ser um endpoint para acessar os usuários
	// O tipo de retorno vai ser um ResponseEntity, que é um tipo
	// específico do Spring pra retornar respostas de requisição Web
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
