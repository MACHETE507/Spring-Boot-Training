package com.example.spring_boot_training.exceptionHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.lang.annotation.Target;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Object> notfoundexception() {
//        String message = messageSource.getMessage("exception.entity-not-found", new String[]{"irwas"}, LocaleContextHolder.getLocale());
//        log.error(message);
//        return new ResponseEntity<>("entity not found",HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> entityNotFoundException(RuntimeException exception, WebRequest request) {
        String message = messageSource.getMessage("exception.entity-not-found", new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
        return handleExceptionInternal(exception, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }




}
