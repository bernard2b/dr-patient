package com.example.dr_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Table( name = "reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    private Long doctorId;
    private Long patientId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime localDateTime;
    private Date reservationDate;
    private Time reservationTime;

    public Reservation() {
        // Default constructor
    }
}
