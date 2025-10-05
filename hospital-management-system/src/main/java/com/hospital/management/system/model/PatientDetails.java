package com.hospital.management.system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientDetails {
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    private int age;

    @NotNull(message = "gender is required")
    private String gender;

    @Size(max = 10, message = "Contact can have maximum 10 characters")
    private String contact;
}
