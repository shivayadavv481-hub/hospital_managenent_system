package com.hospital.management.system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BillingDetails {
    private Long id;

    @NotNull(message = "Amount is required")
    private double amount;

    @NotNull(message = "Status is required")
    @Size(max = 8, message = "Status can have maximum 8 characters")
    private String status;

    @NotNull(message = "Appointment ID is required")
    private Long appointmentId;
}
