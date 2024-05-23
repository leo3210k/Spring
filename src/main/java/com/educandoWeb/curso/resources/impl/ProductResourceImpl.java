package com.educandoWeb.curso.resources.impl;

import java.util.List;

import com.educandoWeb.curso.resources.ProductResource;
import com.educandoWeb.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoWeb.curso.entities.Product;
import com.educandoWeb.curso.services.impl.ProductServiceImpl;

// Usado para falar que nossa classe é um recurso Web que é
// implementado por um controlador Rest
@RestController
@RequestMapping(value = "/products")
public class ProductResourceImpl implements ProductResource {

	private ProductService service;

	public ProductResourceImpl(ProductService service) {
		this.service = service;
	}

	// Método para ser um endpoint para acessar os usuários
	// O tipo de retorno vai ser um ResponseEntity, que é um tipo
	// específico do Spring pra retornar respostas de requisição Web
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
