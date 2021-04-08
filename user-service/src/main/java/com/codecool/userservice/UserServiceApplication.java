package com.codecool.userservice;

import com.codecool.userservice.models.UserModel;
import com.codecool.userservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository) {

        return args -> {
            userRepository.saveAll(Arrays.asList(


                new UserModel("admin", "admin@admin.com", "0777777777"),
                new UserModel("gigi", "gigi@google.com", "0777777771")
            ));
        };

    }

}
