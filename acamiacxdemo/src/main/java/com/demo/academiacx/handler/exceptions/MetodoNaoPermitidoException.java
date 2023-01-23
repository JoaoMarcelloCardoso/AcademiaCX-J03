package com.demo.academiacx.handler.exceptions;

import com.demo.academiacx.handler.resource.ResourceExceptionHandler;

import java.security.InvalidParameterException;

public class MetodoNaoPermitidoException extends RuntimeException {
    public MetodoNaoPermitidoException(String mensagem){
        super(mensagem);
    }
    public MetodoNaoPermitidoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
