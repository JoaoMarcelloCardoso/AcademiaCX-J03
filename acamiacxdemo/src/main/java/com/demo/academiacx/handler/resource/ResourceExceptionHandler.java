package com.demo.academiacx.handler.resource;

import com.demo.academiacx.handler.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handlerRecursoNaoEncontradoExeception(RecursoNaoEncontradoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalhesErro(e.getMessage(), 404l, 404l, System.currentTimeMillis(), "http://localhost:8080/erros/404"));
    }

    @ExceptionHandler(ParametroInvalidoException.class)
    public ResponseEntity<DetalhesErro> handlerParametroInvalidoException(ParametroInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new DetalhesErro(e.getMessage(), 406l, 406l, System.currentTimeMillis(), "http://localhost:8080/erros/406"));
    }
    @ExceptionHandler(RecursoIncorretoException.class)
    public ResponseEntity<DetalhesErro> handlerRequisicaoIncorretaException(RecursoIncorretoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DetalhesErro(e.getMessage(), 400l, 400l, System.currentTimeMillis(), "http://localhost:8080/erros/400"));
    }
    @ExceptionHandler(ErroInternoException.class)
    public ResponseEntity<DetalhesErro> handlerErroInternoException(ErroInternoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DetalhesErro(e.getMessage(), 500l, 500l, System.currentTimeMillis(), "http://localhost:8080/erros/500"));
    }
}