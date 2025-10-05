package com.hospital.management.system.service;

import com.hospital.management.system.entities.Appointment;
import com.hospital.management.system.model.AppointmentDetails;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment addAppointment(AppointmentDetails appointmentDetails);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    void deleteAppointment(Long id);
}
