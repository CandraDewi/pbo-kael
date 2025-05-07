package com.kidaro.kael;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Manager;
import com.kidaro.kael.repository.CustomerRepository;
import com.kidaro.kael.repository.ManagerRepository;

@SpringBootApplication
public class KaelApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaelApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedDatabase(CustomerRepository customerRepository, ManagerRepository managerRepository) {
        return args -> {
            if (customerRepository.count() == 0) {
                Customer customer = new Customer();
                customer.setUsername("customer1");
                customer.setPassword("password1");
                customer.setRole("CUSTOMER");
                customerRepository.save(customer);
            }

            if (managerRepository.count() == 0) {
                Manager manager = new Manager();
                manager.setUsername("manager1");
                manager.setPassword("password1");
                manager.setRole("MANAGER");
                managerRepository.save(manager);
            }
        };
    }
}
