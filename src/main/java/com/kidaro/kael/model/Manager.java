package com.kidaro.kael.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends User {
    public Manager() {}

    public Manager(String username, String password) {
        super(null, username, password);
    }
}
