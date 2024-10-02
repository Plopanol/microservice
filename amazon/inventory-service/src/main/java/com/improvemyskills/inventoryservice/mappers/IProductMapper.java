package com.improvemyskills.inventoryservice.mappers;

import com.improvemyskills.inventoryservice.entity.Product;
import com.improvemyskills.inventoryservice.models.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}