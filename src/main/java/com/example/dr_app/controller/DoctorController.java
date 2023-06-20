package com.example.dr_app.controller;

import com.example.dr_app.model.Doctor;
import com.example.dr_app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/save-doctors")
    public List<Doctor> saveDoctors(@RequestBody List<Doctor> doctorList) {
        return doctorService.saveDoctorsData(doctorList);
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctorsData();
    }

    @GetMapping("/doctor/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorData(id);
    }
}
