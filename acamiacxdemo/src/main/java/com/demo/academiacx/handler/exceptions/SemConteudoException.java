package com.demo.academiacx.handler.exceptions;

public class SemConteudoException extends RuntimeException{

    public SemConteudoException(String message) {
        super(message);
    }

    public SemConteudoException(String message, Throwable cause) {
        super(message, cause);
    }
}
