package com.improvemyskills.orderservice.clients;

import com.improvemyskills.orderservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}?projection=customer_projection")
    Customer getCustomerById(@PathVariable Long id);
    @GetMapping(path = "/customers?projection=customer_projection")
    PagedModel<Customer> getAllCustomers();
}