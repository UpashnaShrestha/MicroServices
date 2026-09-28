package com.microservices.order_service.repo;

import com.microservices.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
