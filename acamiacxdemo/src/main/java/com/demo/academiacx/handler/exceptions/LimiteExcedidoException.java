package com.demo.academiacx.handler.exceptions;

public class LimiteExcedidoException extends RuntimeException{

    public LimiteExcedidoException(String message) {
        super(message);
    }

    public LimiteExcedidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
