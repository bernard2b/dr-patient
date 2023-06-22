package com.example.dr_app.service;

import com.example.dr_app.exceptions.DataBaseException;
import com.example.dr_app.exceptions.NotFoundException;
import com.example.dr_app.model.Doctor;
import com.example.dr_app.model.Patient;
import com.example.dr_app.model.Reservation;
import com.example.dr_app.repository.DoctorRepository;
import com.example.dr_app.repository.PatientRepository;
import com.example.dr_app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


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
                new NotFoundException("No doctor found with id: " + doctorId));
        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new NotFoundException("No patient found with id: " + patientId));

        Reservation reservation = Reservation.builder()
                .doctorId(doctorId)
                .patientId(patientId)
                .date(LocalDateTime.now())
                .build();

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsData() throws DataBaseException {

        try {
            return reservationRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("Error occurred while fetching doctors data.", e);
        }
    }
}
