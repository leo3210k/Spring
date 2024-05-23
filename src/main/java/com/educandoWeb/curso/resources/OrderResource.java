package com.educandoWeb.curso.resources;

import com.educandoWeb.curso.entities.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderResource {
    public ResponseEntity<List<Order>> findAll();

    public ResponseEntity<Order> findById(Long id);
}
