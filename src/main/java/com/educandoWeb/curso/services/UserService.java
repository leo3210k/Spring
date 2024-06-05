package com.educandoWeb.curso.services;

import java.util.List;
import java.util.Optional;

import com.educandoWeb.curso.services.exception.DataBaseException;
import com.educandoWeb.curso.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoWeb.curso.entities.User;
import com.educandoWeb.curso.repositories.UserRepository;

// Poderia ser @Component, que também registra a classe como um componente do Spring,
// podendo ser injetado automaticamente com o @Autowired, mas o @Service é utilizado
// para ficar mais semanticamente específico
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {

		// getReferenceById = melhor que o findById, ele instancia
		// um usuário mas não vai no banco de dados, só deixará um objeto monitorado
		// pelo JPA, para só em seguida poder efetuar uma operação com o banco
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);

			return repository.save(entity);
		} catch (EntityNotFoundException e) {
//		} catch (RuntimeException e) { Exceção mais genérica
//			e.printStackTrace(); Imprimir o erro na tela

			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
