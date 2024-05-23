package com.educandoWeb.curso;

import com.educandoWeb.curso.repositories.impl.UserRepositoryImpl;
import com.educandoWeb.curso.resources.CategoryResource;
import com.educandoWeb.curso.resources.OrderResource;
import com.educandoWeb.curso.resources.ProductResource;
import com.educandoWeb.curso.resources.UserResource;
import com.educandoWeb.curso.resources.impl.CategoryResourceImpl;
import com.educandoWeb.curso.resources.impl.OrderResourceImpl;
import com.educandoWeb.curso.resources.impl.ProductResourceImpl;
import com.educandoWeb.curso.resources.impl.UserResourceImpl;
import com.educandoWeb.curso.services.impl.CategoryServiceImpl;
import com.educandoWeb.curso.services.impl.OrderServiceImpl;
import com.educandoWeb.curso.services.impl.ProductServiceImpl;
import com.educandoWeb.curso.services.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// JPA = Ferramenta de mapeamento objeto relacional padrão do Java,
// ela faz uma conversão entre o modelo orientado a objetos e o paradigma relacional
// do banco de dados relacional

@SpringBootApplication
public class CursoApplication {

	public static void main(String[] args) {
		UserResource user = new UserResourceImpl(new UserServiceImpl(new UserRepositoryImpl()));
		ProductResource product = new ProductResourceImpl(new ProductServiceImpl());
		OrderResource order = new OrderResourceImpl(new OrderServiceImpl());
		CategoryResource category = new CategoryResourceImpl(new CategoryServiceImpl());

		SpringApplication.run(CursoApplication.class, args);
	}

}
