package com.hospital.management.system.controller;

import com.hospital.management.system.entities.Patient;
import com.hospital.management.system.model.PatientDetails;
import com.hospital.management.system.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/allPatients")
    public ResponseEntity< List<Patient>> getAllPatients() {
       List<Patient> patients = patientService.getPatient();
       return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient( @Valid @RequestBody PatientDetails patientDetails) {
        Patient patient = patientService.addPatient(patientDetails);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
