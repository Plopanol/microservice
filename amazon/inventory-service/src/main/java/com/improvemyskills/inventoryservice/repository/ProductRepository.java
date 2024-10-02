package com.improvemyskills.inventoryservice.repository;

import com.improvemyskills.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
