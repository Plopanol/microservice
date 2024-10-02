package com.improvemyskills.inventoryservice.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private double discount;
}
