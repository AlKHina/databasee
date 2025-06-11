package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationError(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                          .getFieldErrors()
                          .stream()
                          .map(error -> error.getField() + ": " + error.getDefaultMessage())
                          .collect(Collectors.joining(", "));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
