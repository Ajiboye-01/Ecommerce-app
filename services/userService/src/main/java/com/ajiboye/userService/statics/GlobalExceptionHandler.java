package com.ajiboye.userService.statics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<String> handle(CustomerException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handle(MethodArgumentNotValidException exception) {
        var error = new HashMap<String, String>();
        for (ObjectError errors : exception.getBindingResult().getAllErrors()) {
            var fieldName = ((FieldError) errors).getField();
            var errorMessage = errors.getDefaultMessage();
            error.put(fieldName, errorMessage);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomErrorResponse(error));
    }
}
