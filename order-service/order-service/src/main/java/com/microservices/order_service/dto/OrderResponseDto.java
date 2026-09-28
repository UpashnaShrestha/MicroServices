package com.microservices.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private Long userId;
    private Long productId;
    private String productName;
    private Double totalPrice;
    private Integer quantity;
    private String status;
}
