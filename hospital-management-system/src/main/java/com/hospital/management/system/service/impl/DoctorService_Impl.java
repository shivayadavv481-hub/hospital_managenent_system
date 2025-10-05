package com.hospital.management.system.service.impl;

import com.hospital.management.system.entities.Doctor;
import com.hospital.management.system.exception.DoctorNotFoundException;
import com.hospital.management.system.model.DoctorDetails;
import com.hospital.management.system.repository.DoctorRepository;
import com.hospital.management.system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService_Impl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    @Override
    public Doctor addDoctor(DoctorDetails doctorDetails) {
        return createDoctor(doctorDetails);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new DoctorNotFoundException("Doctor is not present with this id: " + id);
        }
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    private Doctor createDoctor(DoctorDetails doctorDetails) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setExperience(doctorDetails.getExperience());
        doctor.setPhone(doctorDetails.getPhone());
        return doctorRepository.save(doctor);
    }
}
