package com.hospital.management.system.exception;

public class BillNotFoundException extends RuntimeException {

    private String message;

    public BillNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
