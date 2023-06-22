package com.example.dr_app.service;

import com.example.dr_app.exceptions.ApiRequestException;
import com.example.dr_app.exceptions.DataBaseException;
import com.example.dr_app.exceptions.NotFoundException;
import com.example.dr_app.model.Patient;
import com.example.dr_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public List<Patient> savePatientsData(List<Patient> patientList) {
        try {
            return patientRepository.saveAll(patientList);
        } catch (Exception e) {
            throw new ApiRequestException("Error occurred while sending a request.", e);
        }
    }

    public List<Patient> getPatientsData() throws DataBaseException {
        try {
            return patientRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("Error occurred while fetching doctors data.", e);
        }
    }

    public Patient getPatientData(Long id) {
        boolean exists = patientRepository.existsById(id);

        if(!exists) {
            throw new NotFoundException("Patient with id: " + id + " does not exists.");
        }

        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.get();
    }
}