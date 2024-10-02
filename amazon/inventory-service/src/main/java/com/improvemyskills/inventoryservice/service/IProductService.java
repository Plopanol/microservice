package com.improvemyskills.inventoryservice.service;

import com.improvemyskills.inventoryservice.entity.Product;
import com.improvemyskills.inventoryservice.models.ProductDto;

import java.util.List;

public interface IProductService {

    ProductDto save(Product product);
    ProductDto getProduct(Long productId);
    List<ProductDto> getAllProducts();
}
