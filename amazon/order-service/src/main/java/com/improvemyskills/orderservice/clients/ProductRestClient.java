package com.improvemyskills.orderservice.clients;

import com.improvemyskills.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @PostMapping("/api/products")
    ResponseEntity<Product> postProduct(@RequestBody Product product);

    @GetMapping("/api/products")
    ResponseEntity<Collection<Product>> getAll();

    @GetMapping("/api/products/{productId}")
    ResponseEntity<Product> getProduct(@PathVariable Long productId);
}
