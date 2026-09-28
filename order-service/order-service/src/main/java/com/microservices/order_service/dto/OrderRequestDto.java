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
public class OrderRequestDto {
    private Long userId;
    private Long productId;
    private Integer quantity;
}
