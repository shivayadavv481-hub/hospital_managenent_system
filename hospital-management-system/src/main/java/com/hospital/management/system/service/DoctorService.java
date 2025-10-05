package com.hospital.management.system.service;

import com.hospital.management.system.entities.Doctor;
import com.hospital.management.system.model.DoctorDetails;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    // Define service methods for Doctor entity

    Doctor addDoctor(DoctorDetails doctorDetails);
    Doctor getDoctorById(Long id);
    List<Doctor> getDoctors();
    void deleteDoctor(Long id);

}
