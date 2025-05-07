package com.kidaro.kael.repository;

import com.kidaro.kael.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Optional<Manager> findByUsername(String username);
}
