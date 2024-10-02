package com.improvemyskills.inventoryservice.mappers;

import com.improvemyskills.inventoryservice.entity.Product;
import com.improvemyskills.inventoryservice.models.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface IProductMapper {

    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
