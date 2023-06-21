package com.example.dr_app.repository;

import com.example.dr_app.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
