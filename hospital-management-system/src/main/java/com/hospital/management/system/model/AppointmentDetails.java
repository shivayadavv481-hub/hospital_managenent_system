package com.hospital.management.system.model;

import com.hospital.management.system.entities.Doctor;
import com.hospital.management.system.entities.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDetails {
    private Long id;

    @NotNull(message = "Appointment date is required")
    private LocalDateTime appointmentDate;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
}
