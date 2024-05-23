package com.educandoWeb.curso.services;

import com.educandoWeb.curso.entities.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAll();

    public Order findById(Long id);
}
