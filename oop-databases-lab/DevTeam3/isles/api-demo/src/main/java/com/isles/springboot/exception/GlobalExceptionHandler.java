package com.isles.springboot.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    //used to return a not found response when data does not exist
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    //used to show validation errors from the request body
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException exception) {
        Map<String, String> body = new HashMap<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            body.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(body);
    }
}
