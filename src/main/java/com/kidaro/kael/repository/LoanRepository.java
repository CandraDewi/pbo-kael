package com.kidaro.kael.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kidaro.kael.model.*;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {
    List<Loan> findByCustomer(Customer customer);
}