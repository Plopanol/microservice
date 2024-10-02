package com.improvemyskills.customerservice.models;

import com.improvemyskills.customerservice.entity.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Customer.class}, name = "customer_projection")
public interface CustomerProjection {
    String getFirstName();
    String getLastName();

}
