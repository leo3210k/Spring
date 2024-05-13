package com.educandoWeb.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoWeb.curso.entities.User;
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

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
