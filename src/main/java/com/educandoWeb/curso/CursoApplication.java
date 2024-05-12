package com.educandoWeb.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// JPA = Ferramenta de mapeamento objeto relacional padrão do Java,
// ela faz uma conversão entre o modelo orientado a objetos e o paradigma relacional
// do banco de dados relacional

@SpringBootApplication
public class CursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

}
