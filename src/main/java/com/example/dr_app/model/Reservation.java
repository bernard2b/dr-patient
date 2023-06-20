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
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;


@Data
@Builder
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
    private LocalDateTime date;
    private Date reservationDate;
    private Time reservationTime;

    public Reservation() {
        // Default constructor
    }

    public void setDate(LocalDateTime date) {
        // Convert LocalDateTime to UTC
        ZonedDateTime utcDateTime = date.atZone(ZoneOffset.UTC);
        this.date = utcDateTime.toLocalDateTime();
    }
}
