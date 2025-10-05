package com.hospital.management.system.service.impl;

import com.hospital.management.system.entities.Appointment;
import com.hospital.management.system.entities.Doctor;
import com.hospital.management.system.entities.Patient;
import com.hospital.management.system.exception.AppointmentNotFoundException;
import com.hospital.management.system.model.AppointmentDetails;
import com.hospital.management.system.repository.AppointmentRepository;
import com.hospital.management.system.repository.DoctorRepository;
import com.hospital.management.system.repository.PatientRepository;
import com.hospital.management.system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService_Impl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Appointment addAppointment(AppointmentDetails appointmentDetails) {
        return createAppointment(appointmentDetails);
    }

    private Appointment createAppointment(AppointmentDetails appointmentDetails) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        Optional<Patient> optional = patientRepository.findById(appointmentDetails.getPatientId());
        appointment.setPatient(optional.get());
        Optional<Doctor> optional1 = doctorRepository.findById(appointmentDetails.getDoctorId());
        appointment.setDoctor(optional1.get());
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new AppointmentNotFoundException("Appointment is not present with this id : " + id);
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
