package com.educandoWeb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoWeb.curso.entities.User;

// Vai ser o repository responsável por fazer operações com a entidade User
// Não precisa criar a implementação da interface, porque o spring-data-jpa
// ja tem uma implementação padrão para essa interface
public interface UserRepository extends JpaRepository<User, Long>{

}
