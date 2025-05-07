package com.kidaro.kael.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    private LocalDate date;
    private double amount;

    @Enumerated(EnumType.STRING)
    private SavingStatus status;

    public enum SavingStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}