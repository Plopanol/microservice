package com.improvemyskills.orderservice.service.impl;

import com.improvemyskills.orderservice.Repository.OrderRepository;
import com.improvemyskills.orderservice.entity.OrderPurshase;
import com.improvemyskills.orderservice.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Collection<OrderPurshase> getAllOrders() {
        return orderRepository.findAll();
    }
}
