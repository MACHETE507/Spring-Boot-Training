package com.example.spring_boot_training.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;


@RestControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> notfoundexception() {
        return new ResponseEntity<>("entity not found",HttpStatus.NOT_FOUND);
    //protected ResponseEntity<Object> entityNotFoundException(RuntimeException exception, WebRequest request) {
       // return handleExceptionInternal(exception, "Entity not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
