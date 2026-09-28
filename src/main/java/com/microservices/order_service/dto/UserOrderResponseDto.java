package com.microservices.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserOrderResponseDto {
    private UserResponseDto user;
    private List<ProductOrderItemDto> orderItems;
    private Double totalPrice;
}
