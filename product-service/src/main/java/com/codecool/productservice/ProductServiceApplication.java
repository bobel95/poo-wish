package com.codecool.productservice;

import com.codecool.productservice.model.Product;
import com.codecool.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {

        return args -> {
            productRepository.saveAll
                    (Arrays.asList(
                    Product.builder()
                            .title("Dacia Logan")
                            .description("Ca noua")
                            .userId(1L)
                            .build(),
                    Product.builder()
                            .title("Amplificator Yamaha S-300")
                            .description("Functioneaza perfect")
                            .userId(1L)
                            .build()
                    ));
        };

    }

}
