package com.hospital.management.system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorDetails {
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Specialization is required")
    private String specialization;

    @NotNull(message = "Experience is required")
    private int experience;

    @Size(max = 10, message = "Phone number can have maximum 10 characters")
    private String phone;
}
