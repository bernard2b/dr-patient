package com.example.dr_app.service;

import com.example.dr_app.model.Doctor;
import com.example.dr_app.model.Patient;
import com.example.dr_app.model.Reservation;
import com.example.dr_app.repository.DoctorRepository;
import com.example.dr_app.repository.PatientRepository;
import com.example.dr_app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    public Reservation saveReservationData(Long doctorId, Long patientId) {
        
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "No doctor found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "No patient found"));

        Reservation reservation = new Reservation();
        reservation.setDoctorId(doctorId);
        reservation.setPatientId(patientId);
        reservation.setLocalDateTime(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }
}
