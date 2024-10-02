package com.improvemyskills.customerservice.models;

import com.improvemyskills.customerservice.entity.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customer_projection", types = { Customer.class })
interface CustomerProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();

}
