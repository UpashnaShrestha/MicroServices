package com.microservices.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductOrderItemDto {
    private ProductResponseDto product;
    private Integer quantity;
}
