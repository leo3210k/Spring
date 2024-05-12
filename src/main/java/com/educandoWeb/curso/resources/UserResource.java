package com.educandoWeb.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.User;

// Usado para falar que nossa classe é um recurso Web que é
// implementado por um controlador Rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// Método para ser um endpoint para acessar os usuários
	// O tipo de retorno vai ser um ResponseEntity, que é um tipo
	// específico do Spring pra retornar respostas de requisição Web
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
