package com.educandoWeb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoWeb.curso.entities.Order;
import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.entities.enums.OrderStatus;
import com.educandoWeb.curso.repositories.OrderRepository;
import com.educandoWeb.curso.repositories.UserRepository;

@Configuration
@Profile("test")
// Primeiro caso de injeção de dependência (desacoplada) = Esta classe vai ter que ter uma
// dependência pro UserRepository
// O framework tem um mecanismo de injenção de dependência implícito, automático
// Database seeding
public class TestConfig implements CommandLineRunner {

	// O próprio Spring, na hora que estiver rodando a aplicação,
	// ele vai resolver essa dependência e associar uma instância de UserRepository aqui
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
