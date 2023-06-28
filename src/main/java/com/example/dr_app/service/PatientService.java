package com.example.dr_app.service;

import com.example.dr_app.model.Patient;
import com.example.dr_app.model.PatientGender;
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
        return patientRepository.saveAll(patientList);
    }

    public List<Patient> getPatientsData() {
        return patientRepository.findAll();
    }

    public Patient getPatientData(Long id) {
        boolean exists = patientRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException("Patient with id: " + id + " does not exists.");
        }

        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.get();
    }

    public List<Patient> getPatientsByGenderData(PatientGender gender) {
        return patientRepository.findByGender(gender);
    }
    public List<Patient> getMalePatientsData() {
        return getPatientsByGenderData(PatientGender.MALE);
    }

    public List<Patient> getFemalePatientsData() {
        return getPatientsByGenderData(PatientGender.FEMALE);
    }

    public List<Patient> getOtherGenderPatientsData() {
        return getPatientsByGenderData(PatientGender.OTHER);
    }


}