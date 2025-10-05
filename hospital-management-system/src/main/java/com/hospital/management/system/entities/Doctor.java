package com.hospital.management.system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;
    private String specialization;
    private int experience; // in years
    private String phone;
}
