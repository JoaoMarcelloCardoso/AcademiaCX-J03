package com.demo.academiacx.handler.exceptions;

public class ErroDeFormatoException extends RuntimeException{

    public ErroDeFormatoException(String mensagem) {
        super(mensagem);
    }

    public ErroDeFormatoException (String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
