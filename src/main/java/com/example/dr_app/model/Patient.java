package com.example.dr_app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name = "patients")
public class Patient {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Enumerated(EnumType.ORDINAL)
    private PatientGender gender;
    @Column(
            name = "date_of_birth",
            nullable = false
    )
    private LocalDate date_of_birth;
    @Column(
            name = "contact_number"
    )
    private String contact_number;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;
    private Long doctor_id;

    public Patient(String firstName, String lastName, PatientGender gender, LocalDate date_of_birth, String contact_number, String email, Long doctor_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.contact_number = contact_number;
        this.email = email;
        this.doctor_id = doctor_id;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PatientGender getGender() {
        return gender;
    }

    public void setGender(PatientGender gender) {
        this.gender = gender;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }
}
