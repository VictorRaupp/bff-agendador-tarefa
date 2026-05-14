package com.victor.bffagendadortarefa.infrastructure.exceptions;

public class UnathorizedExcepetion extends RuntimeException{

    public UnathorizedExcepetion(String mensagem) {
        super(mensagem);
    }
    public UnathorizedExcepetion(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
