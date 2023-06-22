package com.example.dr_app.controller;

import com.example.dr_app.exceptions.DataBaseException;
import com.example.dr_app.model.Reservation;
import com.example.dr_app.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/create-reservation")
    public ResponseEntity<Reservation> makeReservation(@RequestParam Long doctorId, @RequestParam Long patientId) {

            Reservation savedReservation = reservationService.saveReservationData(doctorId, patientId);
            return ResponseEntity.ok(savedReservation);

    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() throws DataBaseException {
        return reservationService.getReservationsData();
    }
}
