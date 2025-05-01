package com.kidaro.kael.controller;

import com.kidaro.kael.model.Order;
import com.kidaro.kael.service.OrderService;
import lombok.*;

import org.springframework.http.ResponseEntity; // Added import
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request) {
        // Pass customerName to the service
        return orderService.placeOrder(request.getMaterialId(), request.getQuantity(), request.getCustomerName());
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Added endpoint to get a single order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Getter @Setter
    public static class OrderRequest {
        private Long materialId;
        private int quantity;
        private String customerName; // Added customerName field
    }
}
