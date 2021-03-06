package com.codecool.productservice.controller;

import com.codecool.productservice.model.Product;
import com.codecool.productservice.model.UserModel;
import com.codecool.productservice.model.UserProducts;
import com.codecool.productservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/user/{userId}")
    public UserProducts getProductsByUser(@PathVariable("userId") Long userId) {
        return new UserProducts(
            productRepository.findAllByUserId(userId)
        );
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productRepository.deleteById(productId);
    }
}
