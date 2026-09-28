package com.microservices.order_service.controller;

import com.microservices.order_service.dto.OrderRequestDto;
import com.microservices.order_service.dto.OrderResponseDto;
import com.microservices.order_service.dto.UserOrderResponseDto;
import com.microservices.order_service.mapper.OrderMapper;
import com.microservices.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public OrderResponseDto createOrder(
            @RequestBody OrderRequestDto request) {

        return orderService.createOrder(request);
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponseDto> getOrdersByUserId(
            @PathVariable Long userId) {

        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/user/history/{userId}")
    public UserOrderResponseDto getOrdersByUserIdHistory(
            @PathVariable Long userId) {
        return orderService.getUserOrderHistory(userId);
    }
}
