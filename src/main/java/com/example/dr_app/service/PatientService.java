package com.example.dr_app.service;

import com.example.dr_app.exceptions.DataBaseException;
import com.example.dr_app.exceptions.NotFoundException;
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
    public List<Patient> savePatientsData(List<Patient> patientList) throws DataBaseException {
        try {
            return patientRepository.saveAll(patientList);
        } catch (Exception e) {
            throw new DataBaseException("Error occurred while saving into the database.", e);
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

    public List<Patient> getPatientsByGenderData(PatientGender gender) {

        if(gender == PatientGender.MALE || gender == PatientGender.FEMALE || gender == PatientGender.OTHER) {
            return patientRepository.findByGender(gender);
        } else {
            throw new IllegalStateException("Invalid gender provided");
        }
    }

    public Patient updatePatientData(Long id, Patient patient) {

        Patient existingPatient = getPatientData(id);

        if (patient.getFirstName() != null) {
            existingPatient.setFirstName(patient.getFirstName());
        }
        if(patient.getLastName() !=null) {
            existingPatient.setLastName(patient.getLastName());
        }
        if(patient.getContactNumber() != null) {
            existingPatient.setContactNumber(patient.getContactNumber());
        }

        return patientRepository.save(existingPatient);
    }

    public Patient deletePatientData(Long id) {

        Patient existingPatient = getPatientData(id);
        patientRepository.delete(existingPatient);

        return existingPatient;
    }

}