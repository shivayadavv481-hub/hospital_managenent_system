package com.hospital.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class BillingExceptionController {

    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<BillingErrorResponse> handleBillingNotFoundException(BillNotFoundException exception) {
        BillingErrorResponse errorResponse = new BillingErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),getCurrentTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BillingErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");

       BillingErrorResponse errorResponse = new BillingErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, getCurrentTimestamp());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

        private String getCurrentTimestamp() {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
