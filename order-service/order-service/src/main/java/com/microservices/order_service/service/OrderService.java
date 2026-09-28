package com.microservices.order_service.service;

import com.microservices.order_service.dto.OrderRequestDto;
import com.microservices.order_service.dto.OrderResponseDto;
import com.microservices.order_service.dto.UserOrderResponseDto;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto request);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto getOrderById(Long id);
    List<OrderResponseDto> getOrdersByUserId(Long userId);
    UserOrderResponseDto getUserOrderHistory(Long userId);
}
