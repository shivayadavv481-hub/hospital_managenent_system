package com.hospital.management.system.exception;

public class DoctorNotFoundException extends RuntimeException {
    private String message;

    public DoctorNotFoundException() {}

    public DoctorNotFoundException(String message) {

        super(message);
        this.message = message;
    }
}
