package com.example.dr_app.controller;

import com.example.dr_app.exceptions.DataBaseException;
import com.example.dr_app.model.Patient;
import com.example.dr_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/save-patients")
    public List<Patient> savePatients(@RequestBody List<Patient> patientList) {
        return patientService.savePatientsData(patientList);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() throws DataBaseException {
        return patientService.getPatientsData();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientData(id);
    }
}
