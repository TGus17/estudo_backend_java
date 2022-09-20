package com.estudo.estudo_backend.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudo.estudo_backend.model.error.ErrorMessage;
import com.estudo.estudo_backend.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage error = new ErrorMessage(
            "Not Found", 
            HttpStatus.NOT_FOUND.value(), 
            ex.getMessage()
        );
        
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
