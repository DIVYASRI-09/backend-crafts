package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        repo.save(product);
        return "Product Saved: " + product.getName();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}