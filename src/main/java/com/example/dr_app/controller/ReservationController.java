package com.example.dr_app.controller;

import com.example.dr_app.model.Reservation;
import com.example.dr_app.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/makeReservation")
    public ResponseEntity<Reservation> makeReservation(@RequestParam Long doctorId, @RequestParam Long patientId) {
        try {
            Reservation savedReservation = reservationService.saveReservationData(doctorId, patientId);
            return ResponseEntity.ok(savedReservation);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}
