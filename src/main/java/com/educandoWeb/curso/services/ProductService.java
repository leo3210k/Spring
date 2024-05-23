package com.educandoWeb.curso.services;

import com.educandoWeb.curso.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public Product findById(Long id);
}
