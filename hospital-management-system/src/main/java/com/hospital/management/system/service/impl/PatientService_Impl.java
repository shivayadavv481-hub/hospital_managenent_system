package com.hospital.management.system.service.impl;

import com.hospital.management.system.entities.Patient;
import com.hospital.management.system.exception.PatientNotFoundException;
import com.hospital.management.system.model.PatientDetails;
import com.hospital.management.system.repository.PatientRepository;
import com.hospital.management.system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService_Impl implements PatientService {

    @Autowired
    PatientRepository patientRepository;


    @Override
    public Patient addPatient(PatientDetails patientDetails) {
        return createPatient(patientDetails);
    }

    @Override
    public List<Patient> getPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new PatientNotFoundException("Patient is not present with this id:" + id);
        }
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private Patient createPatient(PatientDetails patientDetails) {
        Patient patient = new Patient();
        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setGender(patientDetails.getGender());
        patient.setContact(patientDetails.getContact());
        return patientRepository.save(patient);
    }
}
