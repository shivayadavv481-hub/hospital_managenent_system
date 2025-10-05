package com.hospital.management.system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient{
    // Patient entity fields and methods
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String name;
    private int age;
    private String gender;
    private String contact;
}
