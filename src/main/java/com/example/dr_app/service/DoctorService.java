package com.example.dr_app.service;

import com.example.dr_app.exceptions.DataBaseException;
import com.example.dr_app.exceptions.NotFoundException;
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
    public List<Doctor> saveDoctorsData(List<Doctor> doctorList) throws DataBaseException {
        try {
            return doctorRepository.saveAll(doctorList);
        } catch (Exception e) {
            throw new DataBaseException("Error occurred while saving to the database.", e);
        }
    }

    public List<Doctor> getDoctorsData() throws DataBaseException {
        try {
            return doctorRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("Error occurred while fetching doctors data.", e);
        }
    }

    public Doctor getDoctorData(Long id) {
        boolean exists = doctorRepository.existsById(id);

        if(!exists) {
            throw new NotFoundException(" Doctor with id: " + id + " does not exists.");
        }
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        return doctorOptional.get();

    }
}
