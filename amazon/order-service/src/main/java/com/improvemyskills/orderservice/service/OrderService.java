package com.improvemyskills.orderservice.service;

import com.improvemyskills.orderservice.entity.OrderPurshase;

import java.util.Collection;

public interface OrderService {

    Collection<OrderPurshase> getAllOrders();
}
