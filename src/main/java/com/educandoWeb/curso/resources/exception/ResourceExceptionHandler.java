package com.educandoWeb.curso.resources.exception;

import com.educandoWeb.curso.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// @ControllerAdvice = vai interceptar as exceções que acontecerem
// para que este objeto possa executar um possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

    private static final long serialVersionUID = 1L;

    // ExceptionHandler = para que seja capaz de interceptar a requisição
    // que deu a exceção para ele cair aqui
    // Esse ex: o método resourceNotFound vai interceptar qualquer exceção
    // do tipo ResourceNotFoundException e vai fazer o tratamento dentro dele
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
