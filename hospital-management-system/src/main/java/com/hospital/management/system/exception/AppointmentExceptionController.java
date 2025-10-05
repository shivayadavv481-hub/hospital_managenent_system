package com.hospital.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class AppointmentExceptionController {
    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<AppointmentErrorResponse> handleAppointmentNotFoundException(AppointmentNotFoundException exception) {
        AppointmentErrorResponse errorResponse = new AppointmentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), getCurrentTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//    add validation error handler

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppointmentErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");

        AppointmentErrorResponse error = new AppointmentErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, getCurrentTimestamp());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

        private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

