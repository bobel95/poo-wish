package com.codecool.userservice;

import com.codecool.userservice.models.UserModel;
import com.codecool.userservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository) {

        return args -> {
            userRepository.save(new UserModel("admin", "admin@admin.com", "0777777777"));
        };

    }

}
