package com.hospital.management.system.exception;

import lombok.Data;

@Data
public class PatientErrorResponse {
    private int status;
    private String message;
    private String timestamp;

    public PatientErrorResponse() {}

    public PatientErrorResponse(int status, String message,String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp=timestamp;
    }
}
