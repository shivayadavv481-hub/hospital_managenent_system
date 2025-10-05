package com.hospital.management.system.controller;

import com.hospital.management.system.entities.Doctor;
import com.hospital.management.system.model.DoctorDetails;
import com.hospital.management.system.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController  {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/allDoctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor>list = doctorService.getDoctors();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor( @Valid @RequestBody DoctorDetails doctorDetails) {
        Doctor doctor = doctorService.addDoctor(doctorDetails);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor( @PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
