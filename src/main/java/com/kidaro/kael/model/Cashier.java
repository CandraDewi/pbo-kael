package com.kidaro.kael.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CASHIER")
public class Cashier extends User {
    public Cashier() {}

    public Cashier(String username, String password) {
        super(null, username, password);
    }
}
