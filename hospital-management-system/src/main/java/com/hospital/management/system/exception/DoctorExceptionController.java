package com.hospital.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class DoctorExceptionController {

    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<DoctorErrorResponse> handleDoctorNotFoundException(DoctorNotFoundException exception) {
        DoctorErrorResponse doctorErrorResponse = new DoctorErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), getCurrentTimestamp());
        return new ResponseEntity<>(doctorErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DoctorErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");

        DoctorErrorResponse errorResponse = new DoctorErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, getCurrentTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
