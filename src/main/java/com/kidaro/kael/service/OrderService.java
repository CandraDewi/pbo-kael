package com.kidaro.kael.service;

import com.kidaro.kael.model.Material;
import com.kidaro.kael.model.Order;
import com.kidaro.kael.repository.MaterialRepository;
import com.kidaro.kael.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepo;
    private final MaterialRepository materialRepo;

    public Order placeOrder(Long materialId, int quantity, String customerName) {
        Material material = materialRepo.findById(materialId)
            .orElseThrow(() -> new RuntimeException("Material not found"));

        if (material.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        material.setStock(material.getStock() - quantity);
        materialRepo.save(material);

        Order order = new Order();
        order.setMaterial(material);
        order.setQuantity(quantity);
        order.setCustomerName(customerName);
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }
}
