package com.kidaro.kael.controller;

import com.kidaro.kael.model.Order;
import com.kidaro.kael.service.OrderService;
import lombok.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(request.getMaterialId(), request.getQuantity());
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Getter @Setter
    public static class OrderRequest {
        private Long materialId;
        private int quantity;
    }
}
