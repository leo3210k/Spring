package com.educandoWeb.curso.resources;

import com.educandoWeb.curso.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductResource {
    public ResponseEntity<List<Product>> findAll();

    public ResponseEntity<Product> findById(Long id);
}
