package com.microservices.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Upashna
 * Created: 9/28/2026
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductResponseDto {
    private Long productId;
    private String name;
    private Double price;
    private Integer stock;
}

