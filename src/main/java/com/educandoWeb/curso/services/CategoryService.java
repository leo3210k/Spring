package com.educandoWeb.curso.services;

import com.educandoWeb.curso.entities.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(Long id);
}
