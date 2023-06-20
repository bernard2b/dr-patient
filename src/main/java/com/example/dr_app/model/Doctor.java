package com.example.dr_app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table( name = "doctors")
public class Doctor {
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
            nullable = false
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;
    @Column(
            name = "specialization",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String specialization;

    @Column(
            name = "experience",
            nullable = false
    )
    private Integer experience;

    @Column(
            name = "contact_number"
    )
    private String contactNumber;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @OneToMany(targetEntity = Patient.class, cascade = CascadeType.ALL)
    @JoinColumn( name = "dr_patient_fk", referencedColumnName = "id")
    private List<Patient> patients;

    public Doctor() {
        // Default constructor
    }
}
