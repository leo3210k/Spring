package com.educandoWeb.curso.resources;

import com.educandoWeb.curso.entities.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryResource {
    public ResponseEntity<List<Category>> findAll();

    public ResponseEntity<Category> findById(Long id);
}
