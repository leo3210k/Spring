package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.Category;
import com.educandoWeb.curso.repositories.CategoryRepository;

// Poderia ser @Component, que também registra a classe como um componente do Spring,
// podendo ser injetado automaticamente com o @Autowired, mas o @Service é utilizado
// para ficar mais semanticamente específico
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
