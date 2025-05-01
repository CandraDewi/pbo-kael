package com.kidaro.kael;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kidaro.kael.model.Cashier;
import com.kidaro.kael.model.Manager;
import com.kidaro.kael.model.Material;
import com.kidaro.kael.repository.MaterialRepository;
import com.kidaro.kael.repository.UserRepository;

@SpringBootApplication
public class KaelApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaelApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepo, MaterialRepository materialRepo) {
        return args -> {
            if (userRepo.count() == 0) { // Changed condition to == 0
                userRepo.save(new Cashier("cashier", "pass"));
                userRepo.save(new Manager("manager", "adminpass"));
            }
            if (materialRepo.count() == 0) { // Changed condition to == 0
                materialRepo.save(new Material(null, "Cement", 50000, 100));
                materialRepo.save(new Material(null, "Bricks", 1000, 1000));
                materialRepo.save(new Material(null, "Sand", 30000, 200));
            }

        };
    }

}
