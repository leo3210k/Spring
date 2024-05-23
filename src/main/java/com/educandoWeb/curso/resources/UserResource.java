package com.educandoWeb.curso.resources;

import com.educandoWeb.curso.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserResource {
    public ResponseEntity<List<User>> findAll();

    public ResponseEntity<User> findById(Long id);
}
