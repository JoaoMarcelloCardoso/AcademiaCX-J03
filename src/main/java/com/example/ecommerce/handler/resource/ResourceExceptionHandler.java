package com.example.ecommerce.handler.resource;

import com.example.ecommerce.handler.exceptions.DetalhesErro;
import com.example.ecommerce.handler.exceptions.ParametroInvalidoException;
import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExeceptionHandler {
    @ExceptionHandler(RecursoNaoEncontradoExeception.class)
    public ResponseEntity<DetalhesErro> handlerRecursoNaoEncontradoExeception(RecursoNaoEncontradoExeception e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalhesErro(e.getMessage(), 404l, 404l, System.currentTimeMillis(), "http://localhost:8080/erros/404"));
    }

    @ExceptionHandler(ParametroInvalidoException.class)
    public ResponseEntity<DetalhesErro> handlerParametroInvalidoException(ParametroInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new DetalhesErro(e.getMessage(), 406l, 406l, System.currentTimeMillis(), "http://localhost:8080/erros/406"));
    }
}