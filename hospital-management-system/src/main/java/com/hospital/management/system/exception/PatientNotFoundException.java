package com.hospital.management.system.exception;

public class PatientNotFoundException extends RuntimeException {
    private String message;

    public PatientNotFoundException() {}

    public PatientNotFoundException(String message)
    {   super(message);
        this.message = message;
    }
}
