package com.codecool.productservice;

import com.codecool.productservice.model.Product;
import com.codecool.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
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
