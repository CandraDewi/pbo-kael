package com.kidaro.kael.service;
import com.kidaro.kael.model.*;
import com.kidaro.kael.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepo;
    private final ManagerRepository managerRepo;

    public Customer registerCustomer(String username, String password) {
        if (customerRepo.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password); // Note: Plain password
        customer.setRole("CUSTOMER");

        return customerRepo.save(customer);
    }

    public Customer loginCustomer(String username, String password) {
        return customerRepo.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public Manager loginManager(String username, String password) {
        return managerRepo.findByUsername(username)
                .filter(manager -> manager.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}