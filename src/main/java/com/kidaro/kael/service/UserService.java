package com.kidaro.kael.service;
import lombok.RequiredArgsConstructor;
import com.kidaro.kael.repository.*;
import org.springframework.stereotype.Service;
import com.kidaro.kael.model.User;
import java.util.Optional;

// Package Dependencies 

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public Optional<User> login(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }
}