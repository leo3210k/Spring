package com.educandoWeb.curso.services;

import com.educandoWeb.curso.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public User findById(Long id);
}
