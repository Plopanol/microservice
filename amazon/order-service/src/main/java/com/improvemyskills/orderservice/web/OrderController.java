package com.improvemyskills.orderservice.web;

import com.improvemyskills.orderservice.clients.CustomerRestClient;
import com.improvemyskills.orderservice.clients.ProductRestClient;
import com.improvemyskills.orderservice.entity.OrderPurshase;
import com.improvemyskills.orderservice.models.Customer;
import com.improvemyskills.orderservice.models.Product;
import com.improvemyskills.orderservice.service.OrderService;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    CustomerRestClient customerRestClient;
    ProductRestClient productRestClient;
    OrderService orderService;

    public OrderController(CustomerRestClient customerRestClient, ProductRestClient productRestClient, OrderService orderService) {
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
        this.orderService = orderService;
    }

    @GetMapping("/customers")
    public ResponseEntity<PagedModel<Customer>> getCustomerRestClient() {
        return new ResponseEntity<>(customerRestClient.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Collection<Product>> getProductRestClient() {
        return productRestClient.getAll();
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderPurshase> placeAnOrder(@RequestBody OrderPurshase orderPurshase){
        return null;
    }

    @GetMapping("/orders")
    public ResponseEntity<Collection<OrderPurshase>> getOrders(){
        /*PagedModel<Customer> customers = customerRestClient.getAllCustomers();
        Collection<Product> products = productRestClient.getAll();
        Collection<OrderPurshase> orders = orderService.getAllOrders().stream()
                .forEach(orderPurshase -> {
                });*/
        return null;
    }



}
