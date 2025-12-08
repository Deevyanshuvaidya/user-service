package com.example.user_service.advice;

import com.example.user_service.exception.ResourcenotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcenotFoundException.class)
    public ResponseEntity<?>handleNotFound(ResourcenotFoundException ex){

        Map<String,Object> error = new HashMap<>();
        error.put("timestamp",LocalDateTime.now());
        error.put("message",ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
