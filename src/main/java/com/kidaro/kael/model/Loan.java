package com.kidaro.kael.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDate borrowingDate;
    private double amount;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private String notes;

    public enum LoanStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}