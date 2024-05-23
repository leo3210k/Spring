package com.educandoWeb.curso.services.impl;

import java.util.List;
import java.util.Optional;

import com.educandoWeb.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.Product;
import com.educandoWeb.curso.repositories.ProductRepository;

// Poderia ser @Component, que também registra a classe como um componente do Spring,
// podendo ser injetado automaticamente com o @Autowired, mas o @Service é utilizado
// para ficar mais semanticamente específico
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
