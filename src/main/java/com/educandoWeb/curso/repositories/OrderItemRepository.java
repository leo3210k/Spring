package com.educandoWeb.curso.repositories;

import com.educandoWeb.curso.entities.OrderItem;
import com.educandoWeb.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Vai ser o repository responsável por fazer operações com a entidade User
// Não precisa criar a implementação da interface, porque o spring-data-jpa
// ja tem uma implementação padrão para essa interface
// Classe que salva os dados no banco
// Não é necessário utilizar @Repository (como o @Component),
// porque a classe ja está herdando do JpaRepository que já
// está registrado como componente do Spring
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
