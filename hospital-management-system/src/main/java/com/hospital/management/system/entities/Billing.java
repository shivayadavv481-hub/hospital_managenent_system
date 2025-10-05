package com.hospital.management.system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "billings")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private double amount;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
