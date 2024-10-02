package com.improvemyskills.orderservice.Repository;

import com.improvemyskills.orderservice.entity.OrderPurshase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderPurshase, String> {
}
