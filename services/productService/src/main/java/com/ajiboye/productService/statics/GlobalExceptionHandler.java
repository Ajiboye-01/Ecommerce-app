package com.ajiboye.productService.statics;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<String> handle(ProductPurchaseException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handles(MethodArgumentNotValidException exception){
        var errors = new HashMap<String, String>();
        for(ObjectError objectError : exception.getBindingResult().getAllErrors()){
            var fieldName = ((FieldError)objectError).getField();
            var errorMessage = objectError.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomErrorResponse(errors));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handler(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

}
