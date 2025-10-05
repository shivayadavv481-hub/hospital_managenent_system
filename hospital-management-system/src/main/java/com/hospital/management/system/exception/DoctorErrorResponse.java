package com.hospital.management.system.exception;

import lombok.Data;

@Data
public class DoctorErrorResponse {
    private int status;
    private String message;
    private String timestamp;

    public DoctorErrorResponse() {
    }

    public DoctorErrorResponse(int status, String message, String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
