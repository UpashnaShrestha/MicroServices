package com.microservices.order_service.mapper;

import com.microservices.order_service.dto.OrderResponseDto;
import com.microservices.order_service.entity.Order;
import org.springframework.stereotype.Component;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@Component
public class OrderMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setProductId(order.getProductId());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        return dto;
    }
}
