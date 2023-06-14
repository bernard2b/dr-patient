package com.example.dr_app.service;

import com.example.dr_app.model.Doctor;
import com.example.dr_app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    public List<Doctor> saveDoctorsData(List<Doctor> doctorList) {
        return doctorRepository.saveAll(doctorList);
    }

    public List<Doctor> getDoctorsData() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorData(Long id) {
        boolean exists = doctorRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(" Doctor with id: " + id + " does not exists.");
        }

        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        return doctorOptional.get();

    }
}
