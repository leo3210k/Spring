package com.educandoWeb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.Category;
import com.educandoWeb.curso.services.CategoryService;

// Usado para falar que nossa classe é um recurso Web que é
// implementado por um controlador Rest
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	// Método para ser um endpoint para acessar os usuários
	// O tipo de retorno vai ser um ResponseEntity, que é um tipo
	// específico do Spring pra retornar respostas de requisição Web
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
