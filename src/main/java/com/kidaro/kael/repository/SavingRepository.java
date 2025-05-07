package com.kidaro.kael.repository;

import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingRepository extends JpaRepository<Saving, String> {
    List<Saving> findByCustomer(Customer customer);
}