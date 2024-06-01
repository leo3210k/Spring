package com.educandoWeb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Usado para falar que nossa classe é um recurso Web que é
// implementado por um controlador Rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;
	
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

	// Para dizer que esse objeto vai chegar no modo json na hora de
	// fazer a requisição, e esse json vai ser deserializado para o objeto
	// User, precisa colocar a anotation @RequestBody
	@PostMapping
	public ResponseEntity<User>  insert(@RequestBody User obj) {
		obj = service.insert(obj);

		// Forma adquada de inserir um recurso no banco de dados
		// Retorna código 201 = você criou um recurso no banco
		// Retorna a location do recurso no banco
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
