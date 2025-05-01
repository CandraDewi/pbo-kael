package com.kidaro.kael.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders") //
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName; // Added customer name field
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}
