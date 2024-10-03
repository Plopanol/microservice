package com.improvemyskills.orderservice.clients;

import com.improvemyskills.orderservice.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
// TODO Non utiliser pour l'instant, est remplacer par Resilience4J
@Component
public class FallBackOpenFeign implements ProductRestClient{
    @Override
    public ResponseEntity<Product> postProduct(Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Product>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Product> getProduct(Long productId) {
        return new ResponseEntity<>(new Product(), HttpStatus.NO_CONTENT);
    }
}