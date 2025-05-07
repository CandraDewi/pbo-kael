package com.kidaro.kael.controller;
import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Manager;
import com.kidaro.kael.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public Customer register(@RequestParam String username, @RequestParam String password) {
        return authService.registerCustomer(username, password);
    }

    @PostMapping("/login/customer")
    public Customer loginCustomer(@RequestParam String username, @RequestParam String password) {
        return authService.loginCustomer(username, password);
    }

    @PostMapping("/login/manager")
    public Manager loginManager(@RequestParam String username, @RequestParam String password) {
        return authService.loginManager(username, password);
    }
}
