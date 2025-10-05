package com.hospital.management.system.service;

import com.hospital.management.system.entities.Patient;
import com.hospital.management.system.model.PatientDetails;

import java.util.List;
import java.util.Optional;

public interface PatientService{
    // Define methods for patient management

    Patient addPatient(PatientDetails patientDetails);
    List<Patient> getPatient();
    Patient getPatientById(Long id);
    void deletePatient(Long id);


}
