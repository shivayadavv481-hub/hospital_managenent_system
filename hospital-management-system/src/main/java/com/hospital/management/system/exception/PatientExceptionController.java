package com.hospital.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class PatientExceptionController {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<PatientErrorResponse> handlePatientNotFoundException(PatientNotFoundException exception) {
        PatientErrorResponse error = new PatientErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), getCurrentTimestamp());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PatientErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");

        PatientErrorResponse errorResponse = new PatientErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, getCurrentTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
