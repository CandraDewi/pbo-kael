package com.kidaro.kael.repository;

import com.kidaro.kael.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
