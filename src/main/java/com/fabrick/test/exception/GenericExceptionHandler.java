package com.fabrick.test.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={BadRequestException.class})
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException e){
        logger.error("Inside handleBadRequestException");
        ResponseModel responseModel = new ResponseModel("API000","Errore tecnico  La condizione BP049 non e' prevista per il conto id 14537780");
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
/*
    @ExceptionHandler(value={Throwable.class})
    protected ResponseEntity<Object> handleThrowableException(Throwable e){
        logger.error("Inside Throwable handler");
        ResponseModel responseModel = new ResponseModel("uej9","ciao!");
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }*/


}
