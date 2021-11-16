package com.fabrick.test.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(){
    }
}
