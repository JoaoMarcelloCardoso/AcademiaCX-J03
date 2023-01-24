package com.academiacxbd.atividadebd.handler.exceptions;

public class RecursoNaoImplementadoException extends RuntimeException {

    public RecursoNaoImplementadoException(String message) {
        super(message);
    }

    public RecursoNaoImplementadoException(String message, Throwable cause) {
        super(message, cause);
    }

}