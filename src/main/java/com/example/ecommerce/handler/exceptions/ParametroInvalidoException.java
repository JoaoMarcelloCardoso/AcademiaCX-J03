package com.example.ecommerce.handler.exceptions;

public class ParametroInvalidoException extends RuntimeException {
    public ParametroInvalidoException(String message) {
        super(message);
    }
}