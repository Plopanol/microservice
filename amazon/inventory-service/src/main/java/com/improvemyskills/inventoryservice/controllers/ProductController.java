package com.improvemyskills.inventoryservice.controllers;

import com.improvemyskills.inventoryservice.entity.Product;
import com.improvemyskills.inventoryservice.models.ProductDto;
import com.improvemyskills.inventoryservice.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    ResponseEntity<ProductDto> postProduct(@RequestBody Product product){
        ProductDto productDto = productService.save(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/products")
    ResponseEntity<List<ProductDto>> getAll(){
        List<ProductDto> productDtoList = productService.getAllProducts();
        try {
            // TODO Pour le test de timeout
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    ResponseEntity<ProductDto> getProduct(@PathVariable Long productId){
        ProductDto productDto = productService.getProduct(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
}
