package com.improvemyskills.inventoryservice.service.impl;

import com.improvemyskills.inventoryservice.entity.Product;
import com.improvemyskills.inventoryservice.mappers.IProductMapper;
import com.improvemyskills.inventoryservice.models.ProductDto;
import com.improvemyskills.inventoryservice.repository.ProductRepository;
import com.improvemyskills.inventoryservice.service.IProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private IProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, IProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(Product product) {
        return  productMapper.toDto(
                productRepository.save(product)
        );
    }

    @Override
    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map( productMapper::toDto)
                .get();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
