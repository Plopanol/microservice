package com.improvemyskills.orderservice.entity;

import com.improvemyskills.orderservice.models.Customer;
import com.improvemyskills.orderservice.models.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;


import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPurshase {
    @Id
    private String id;
    private Long customerId;
    private Collection<Long> productIds;

    @Transient
    private Customer customer;
    @Transient
    private Collection<Product> products;

}
