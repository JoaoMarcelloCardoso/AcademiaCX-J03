package com.example.academiacx.handler.exceptions;

public class ErroInternoException extends RuntimeException{
    public ErroInternoException(String mensagem){
        super(mensagem);
    }

    public ErroInternoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
