package com.improvemyskills.orderservice;

import com.improvemyskills.orderservice.Repository.OrderRepository;
import com.improvemyskills.orderservice.entity.OrderPurshase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository){
        return args -> {
            Collection<OrderPurshase> orderPurshases = List.of(
                    OrderPurshase.builder().id(UUID.randomUUID().toString()).customerId(1L).productIds(List.of(1L,2L)).build(),
                    OrderPurshase.builder().id(UUID.randomUUID().toString()).customerId(2L).productIds(List.of(3L,4L)).build(),
                    OrderPurshase.builder().id(UUID.randomUUID().toString()).customerId(3L).productIds(List.of(2L,3L)).build()
                    );
            orderRepository.saveAll(orderPurshases);
        };
    }
}
