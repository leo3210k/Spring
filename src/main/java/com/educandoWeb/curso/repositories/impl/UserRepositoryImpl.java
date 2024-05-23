package com.educandoWeb.curso.repositories.impl;

import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> db = new ArrayList<>();

    public UserRepositoryImpl() {
        this.db.add(new User(1L, "leo", "leocoelho@gmail.com", "86994778760", "123456"));
    }

    @Override
    public List<User> findAll() {
        return db;
    }

    @Override
    public Optional<User> findById(Long id) {
        for(int i = 0; i < db.size(); i++) {
            if(db.get(i).getId() == id) {
                return Optional.of(db.get(i));
            }
        }
        throw new IllegalArgumentException("Invalid Argument");
    }
}
